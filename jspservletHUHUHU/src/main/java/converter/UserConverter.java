package converter;

import org.modelmapper.ModelMapper;

import dto.UserDTO;
import entity.UserEntity;

public class UserConverter {
	private ModelMapper modelMapper = new ModelMapper();

	public UserDTO convertEntityToDTO(UserEntity entity) {
		UserDTO dto = modelMapper.map(entity, UserDTO.class);
		return dto;
	}

	public UserEntity convertDTOToEntity(UserDTO dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		return entity;
	}
}
