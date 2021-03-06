package converter;

import org.modelmapper.ModelMapper;

import dto.BuildingDTO;
import entity.BuildingEntity;

public class BuildingConverter {
	private ModelMapper modelMapper = new ModelMapper();

	public BuildingDTO convertEntityToDTO(BuildingEntity entity) {
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
		return dto;
	}

	public BuildingEntity convertDTOToEntity(BuildingDTO dto) {
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		return entity;
	}
}
