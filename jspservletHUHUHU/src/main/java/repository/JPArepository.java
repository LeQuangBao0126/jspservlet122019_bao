package repository;

import java.util.List;
import java.util.Map;

public interface JPArepository<T> {
	List<T> findAll(Map<String,Object> params,Object... where);
	List<T> findAll(String sql,Object...where);
	void insert(Object object);
 }
