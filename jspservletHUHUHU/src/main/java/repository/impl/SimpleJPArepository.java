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
	public List<T> findAll(Map<String,Object> params,Object... where) {
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
				sql = createSQLfindAllcommon(sql,params);
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
		if(params!=null && params.size() > 0) {
		   	String[] keys = new String[params.size()];
		   	Object[] values = new Object[params.size()];
		   	int index = 0;
		   	for(Map.Entry<String,Object> item : params.entrySet()) {
		   		keys[index] = item.getKey();
		   		values[index] = item.getValue();
		   		index++;
		   	}
		   	for(int i = 0; i< keys.length ;i++) {  		
		   		if(values[i] instanceof String) {
		   			if(StringUtils.isNotBlank(values[i].toString())) {
		   				sql.append(" and b."+keys[i]+" like '%"+values[i]+"%'");
		   			}		   			
		   		}else {
		   			if(values[i] != null) {
		   				sql.append(" and b."+keys[i]+" = "+values[i]+"");
		   			}	   			
		   		}
		   	}
		}  
		//nếu tất cả ko thoả thì vẫn return lại câu sql cũ
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

	@Override
	public void insert(Object object) {
	String sql = createSQLinsert();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			
			Class<?> aClass = object.getClass();
			int index =1 ;
			for(Field aField : aClass.getDeclaredFields()) {
				aField.setAccessible(true);
				statement.setObject(index, aField.get(object));
				index++;
			}
			
			Class<?> parentClass = aClass.getSuperclass();
			int parentIndex = aClass.getDeclaredFields().length +1;
			while(parentClass != null) {
				for(Field aField : parentClass.getDeclaredFields()) {
					aField.setAccessible(true);
					statement.setObject(parentIndex, aField.get(object));
					parentIndex++;
				}
				parentClass = parentClass.getSuperclass();
			}
			statement.executeUpdate();
			connection.commit();
		}catch(SQLException | IllegalAccessException e) {
			if(connection!=null) {
				try {
					System.out.println(e.getMessage());
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println(e.getMessage());
				}
			}
		}finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private String createSQLinsert() {
		String tableName ="";
		if(zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for(Field field : zClass.getDeclaredFields()) {
			if(fields.length() > 1 ) {
				fields.append(",");
				params.append(",");
			}
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		Class<?> parentClass = zClass.getSuperclass();
		
		while(parentClass != null) {
			//xử lý
			for(Field field : parentClass.getDeclaredFields()) {
				if(fields.length() > 1 ) {
					fields.append(",");
					params.append(",");
				}
				if(field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		
		String sql = "INSERT INTO "+tableName+"("+fields.toString()+") VALUES("+params.toString()+")";
		return sql;
	}

}
