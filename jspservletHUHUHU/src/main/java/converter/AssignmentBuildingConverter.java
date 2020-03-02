package converter;

import org.modelmapper.ModelMapper;

import dto.AssignmentBuildingDTO;
import entity.AssignmentBuildingEntity;

public class AssignmentBuildingConverter {
	private ModelMapper modelMapper = new ModelMapper();

	public AssignmentBuildingDTO convertEntityToDTO(AssignmentBuildingEntity entity) {
		AssignmentBuildingDTO dto = modelMapper.map(entity, AssignmentBuildingDTO.class);
		return dto;
	}

	public AssignmentBuildingEntity convertDTOToEntity(AssignmentBuildingDTO dto) {
		AssignmentBuildingEntity entity = modelMapper.map(dto, AssignmentBuildingEntity.class);
		return entity;
	}
}
