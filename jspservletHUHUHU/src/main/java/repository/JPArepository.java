package repository;

import java.util.List;
import java.util.Map;

public interface JPArepository<T> {
	List<T> findAll(Map<String,Object> params,Object... where);
	List<T> findAll(String sql,Object...where);
	Long insert(Object object);
	//
	//T findById(Long id);
	void update(Object objectUpdate);
	//
	void delete(Long id);
	void deleteByProperty(String where);
	// T findById(Long id)
	int count(String sql);
 }
