package repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import anotation.Column;
import anotation.Table;
import mapper.ResultSetMapper;
import repository.EntityManagerFactory;
import repository.JPArepository;

public class SimpleJPArepository<T> implements JPArepository<T> {
	private Class<T> zClass;

	@SuppressWarnings("unchecked")
	public SimpleJPArepository() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType para = (ParameterizedType) type;
		zClass = (Class<T>) para.getActualTypeArguments()[0];
	}

	// hàm findAll này phuc vụ 2 nhu cầu
	// 1 là truy vấn bảng ko điểu kiện
	// 2 là có điều kiện ...nhờ vào parameter list này
	@Override
	public List<T> findAll(Map<String, Object> params, Object... where) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		String tableName = "";
		if (connection != null) {
			try {
				if (zClass.isAnnotationPresent(Table.class)) {
					Table table = zClass.getAnnotation(Table.class);
					tableName = table.name();
				}
				StringBuilder sql = new StringBuilder("select * from " + tableName + "b where 1=1 ");
				sql = createSQLfindAllcommon(sql, params);
				if (where != null && where.length == 1) {
					sql.append(where[0]);
				}
				statement = connection.prepareStatement(sql.toString());
				resultset = statement.executeQuery();
				return resultSetMapper.mapRow(resultset, zClass);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return new ArrayList<>();
			} finally {
				try {
					connection.close();
					statement.close();
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return new ArrayList<>();
	}

	protected StringBuilder createSQLfindAllcommon(StringBuilder sql, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] values = new Object[params.size()];
			int index = 0;
			for (Map.Entry<String, Object> item : params.entrySet()) {
				keys[index] = item.getKey();
				values[index] = item.getValue();
				index++;
			}
			for (int i = 0; i < keys.length; i++) {
				if (values[i] instanceof String) {
					if (StringUtils.isNotBlank(values[i].toString())) {
						sql.append(" and b." + keys[i] + " like '%" + values[i] + "%'");
					}
				} else {
					if (values[i] != null) {
						sql.append(" and b." + keys[i] + " = " + values[i] + "");
					}
				}
			}
		}
		return sql;
	}

	@Override
	public List<T> findAll(String sql, Object... where) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		ResultSet resultset = null;
		if (connection != null) {
			try {
				StringBuilder builder = new StringBuilder(sql);
				if (where != null && where.length == 1) {
					builder.append(where[0]);
				}
				statement = connection.createStatement();
				resultset = statement.executeQuery(builder.toString());
				List<T> list = resultSetMapper.mapRow(resultset, zClass);
				return list;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return new ArrayList<>();
			} finally {
				try {
					connection.close();
					statement.close();
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return new ArrayList<>();
	}

	@Override
	public Long insert(Object object) {
		String sql = createSQLinsert();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			Class<?> aClass = object.getClass();
			int index = 1;
			for (Field aField : aClass.getDeclaredFields()) {
				aField.setAccessible(true);
				statement.setObject(index, aField.get(object));
				index++;
			}

			Class<?> parentClass = aClass.getSuperclass();
			int parentIndex = aClass.getDeclaredFields().length + 1;
			while (parentClass != null) {
				for (Field aField : parentClass.getDeclaredFields()) {
					aField.setAccessible(true);
					statement.setObject(parentIndex, aField.get(object));
					parentIndex++;
				}
				parentClass = parentClass.getSuperclass();
			}

			int affectedRows = statement.executeUpdate();
			connection.commit();
			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			} else {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					Long id = resultSet.getLong(1);
					return id;
				}
			}
		} catch (SQLException | IllegalAccessException e) {
			if (connection != null) {
				try {
					System.out.println(e.getMessage());
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println(e.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1L;
	}

	private String createSQLinsert() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			// xử lý
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		String sql = "INSERT INTO " + tableName + "(" + fields.toString() + ") VALUES(" + params.toString() + ")";
		return sql;
	}

	@Override
	public void update(Object objectUpdate) {
		String sqlUpdate = createSQLupdate(objectUpdate);
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sqlUpdate);
			Class<?> aClass = objectUpdate.getClass();
			int i = 1;
			for (Field field : aClass.getDeclaredFields()) {
				field.setAccessible(true);
				if (field.get(objectUpdate) != null) {
					statement.setObject(i, field.get(objectUpdate));
					i++;
				}
			}
			Class<?> parentClass = aClass.getSuperclass();
			int parentIndex = aClass.getDeclaredFields().length + 1;
			Object id = null;
			while (parentClass != null) {
				for (Field aField : parentClass.getDeclaredFields()) {
					aField.setAccessible(true);
					if (aField.getAnnotation(Column.class).name().equals("id")) {
						id = aField.get(objectUpdate);
						break;
					}
					statement.setObject(parentIndex, aField.get(objectUpdate));
					parentIndex++;
				}
				parentClass = parentClass.getSuperclass();
			}
			statement.setObject(parentIndex, id);
			statement.executeUpdate(sqlUpdate);
			connection.commit();
		} catch (SQLException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
	}

	private String createSQLupdate(Object objupdate) {
		String tableName = "";
		StringBuilder sbFieldAndValues = new StringBuilder("");

		if (zClass.isAnnotationPresent(Table.class)) {
			tableName = zClass.getAnnotation(Table.class).name();
		}
		Class<?> aClass = objupdate.getClass();
		for (Field field : aClass.getDeclaredFields()) {
			field.setAccessible(true);
			String columnName = field.getAnnotation(Column.class).name();
			if (field.getAnnotation(Column.class).name().equals("id")) {
				continue;
			}
			if (sbFieldAndValues.length() > 1) {
				sbFieldAndValues.append(" , ");
			}
			sbFieldAndValues.append(columnName + " = ?");
		}
		Class<?> parentClass = aClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				field.setAccessible(true);
				String columnName = field.getAnnotation(Column.class).name();
				if (field.getAnnotation(Column.class).name().equals("id")) {
					continue;
				}
				if (sbFieldAndValues.length() > 1) {
					sbFieldAndValues.append(" , ");
				}
				sbFieldAndValues.append(columnName + " = ?");
			}
			parentClass = parentClass.getSuperclass();
		}

		String sql = "Update " + tableName + " SET " + sbFieldAndValues.toString() + " where " + tableName + ".id = ? ";
		return sql.toString();
	}

	@Override
	public void delete(Long id) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			tableName = zClass.getAnnotation(Table.class).name();
		}
		String sql = "delete from " + tableName + " where id= " + id;
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteByProperty(String where) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			tableName = zClass.getAnnotation(Table.class).name();
		}
		String sql = "delete from " + tableName + " where 1=1 " + where;
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			if (connection != null) {
				connection.commit();
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int count(String sql) {
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		ResultSet resultset = null;
		int row= 0;
		if (connection != null) {
			try {
				statement = connection.createStatement();
				resultset = statement.executeQuery(sql);
				while (resultset.next()) {
					row = resultset.getInt("COUNT(*)");
				}
				return row;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return 0;
			} finally {
				try {
					connection.close();
					statement.close();
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;

	}

}
