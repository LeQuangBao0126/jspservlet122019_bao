package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import converter.UserConverter;
import dto.UserDTO;
import entity.UserEntity;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

public class UserService implements IUserService {
	private IUserRepository userRepository = new UserRepository(); 
	private UserConverter userConverter = new UserConverter();
	@Override
	public List<UserDTO> findStaffs(String rolecode) {
		List<UserEntity> resultentity = userRepository.findUserByRole(rolecode);
	     List<UserDTO> listDto = new ArrayList<>();
	       for(UserEntity item : resultentity) {
	    	   UserDTO dto = userConverter.convertEntityToDTO(item);
	    	   listDto.add(dto);
	       }
		return listDto;
	}
	@Override
	public UserDTO checkUserAssignment(Long userId,Long buildingId) {
		//tìm xem nhan vien có đang quản lý toà nhà ko. findByIdAndBuildingId
		UserDTO userDTO  =userConverter.convertEntityToDTO(userRepository.findByIdAndBuildingId(userId, buildingId));
		return userDTO;
	}

}