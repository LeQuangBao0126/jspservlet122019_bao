package repository.impl;

import entity.AssignmentBuildingEntity;
import repository.IAssignmentBuildingRepository;

public class AssignmentBuildingRepository extends SimpleJPArepository<AssignmentBuildingEntity> implements IAssignmentBuildingRepository {

	@Override
	public void insertAssignmentBuilding(AssignmentBuildingEntity entity) {
		this.insert(entity);
	}



}
