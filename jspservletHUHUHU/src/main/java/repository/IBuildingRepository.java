package repository;

import java.util.List;
import java.util.Map;

import builder.BuildingSearchBuilder;
import entity.BuildingEntity;

public interface IBuildingRepository extends JPArepository<BuildingEntity> {
		Long insert(BuildingEntity entity);
		List<BuildingEntity> findAll(Map<String,Object> params,BuildingSearchBuilder builder);
		BuildingEntity findById(Long buildingId);
		void update(BuildingEntity entity);
		void delete(Long id );
		List<BuildingEntity> getListBuilding();
		//delete các field trong bảng lien quan
		void deleteWithTransaction(Long[] ids);
}
