package repository.impl;

import java.util.List;

import entity.AssignmentBuildingEntity;
import repository.IAssignmentBuildingRepository;

public class AssignmentBuildingRepository extends SimpleJPArepository<AssignmentBuildingEntity> implements IAssignmentBuildingRepository {
	@Override
	public List<AssignmentBuildingEntity> findByBuildingid(Long id) {
		String sql ="select * from assignmentbuilding where buildingid = "+id+"";
		return super.findAll(sql);
	}

	@Override
	public void insertStaffByBuildingid(AssignmentBuildingEntity entity) {
		 this.insert(entity);
	}

	@Override
	public void deleteAssignmentByBuildingId(Long buildingId,Long StaffId) {
		String where =" AND buildingid = "+buildingId+" AND staffid= "+StaffId+"  ";
		this.deleteByProperty(where);
	}

	

	
}
