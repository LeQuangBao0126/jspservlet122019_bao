package service.impl;

import converter.AssignmentBuildingConverter;
import dto.AssignmentBuildingDTO;
import repository.IAssignmentBuildingRepository;
import repository.impl.AssignmentBuildingRepository;
import service.IAssignmentBuildingService;

public class AssignmentBuildingService implements IAssignmentBuildingService {
	private IAssignmentBuildingRepository abr = new AssignmentBuildingRepository();
	private AssignmentBuildingConverter converter = new AssignmentBuildingConverter();
	
	@Override
	public void insertAssignmentBuilding(AssignmentBuildingDTO dto) {
		abr.insertAssignmentBuilding(converter.convertDTOToEntity(dto));
	}

}