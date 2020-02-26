package repository;

import java.util.List;
import java.util.Map;

import builder.BuildingSearchBuilder;
import entity.BuildingEntity;

public interface IBuildingRepository extends JPArepository<BuildingEntity> {
		void insert(BuildingEntity entity);
		List<BuildingEntity> findAll(Map<String,Object> params,BuildingSearchBuilder builder);
}
