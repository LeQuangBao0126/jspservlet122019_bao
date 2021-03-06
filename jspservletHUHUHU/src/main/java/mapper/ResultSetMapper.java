package mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import anotation.Column;
import anotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs , Class<T> zClass){
		List<T> results = new ArrayList<>();
			try {
				if(zClass.isAnnotationPresent(Entity.class)) {
					ResultSetMetaData rsMetadata = rs.getMetaData();
					Field[] fields = zClass.getDeclaredFields();
					while(rs.next()) {
						T object = zClass.newInstance();
						for(int i = 0 ;i < rsMetadata.getColumnCount() ;++i) {
							String ColumnName = rsMetadata.getColumnName(i+1);
							Object columnValue = rs.getObject(i+1);							
							for(Field field : fields) {
								if(field.isAnnotationPresent(Column.class)) {
									Column column = field.getAnnotation(Column.class);
									if(column.name().equals(ColumnName) && columnValue != null ) {
										BeanUtils.setProperty(object, field.getName(),columnValue);
										break;
									}
								}
							}
							Class<?> parentClass = zClass.getSuperclass();
							while(parentClass!=null) {
								for(Field field : parentClass.getDeclaredFields()) {
									if(field.isAnnotationPresent(Column.class)) {
										Column column = field.getAnnotation(Column.class);
										if(column.name().equals(ColumnName) && columnValue != null ) {
											BeanUtils.setProperty(object, field.getName(),columnValue);
											break;
										}
									}
								}
								parentClass = parentClass.getSuperclass();
							}
						}
						results.add(object);
					}
				}
			}catch(SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
				System.out.println(e.getMessage());
				return new ArrayList<>();
			}
		return results;
	}
}
