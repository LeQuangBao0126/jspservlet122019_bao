package repository;

import java.util.List;

import dto.AssignmentBuildingDTO;
import entity.AssignmentBuildingEntity;

public interface IAssignmentBuildingRepository {
		//tim nhan vien theo buildingid
	List<AssignmentBuildingEntity> findByBuildingid(Long id);
	void insertStaffByBuildingid(AssignmentBuildingEntity entity);
	//
	void deleteAssignmentByBuildingId(Long buildingId);
}
