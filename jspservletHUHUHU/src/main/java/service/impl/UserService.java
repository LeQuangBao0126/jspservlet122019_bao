package service.impl;

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
	public List<UserDTO> findStaffs(String rolecode ,Long buildingId) {
		List<UserEntity> entities = userRepository.findUserByRole(rolecode);
		List<UserDTO> staffs = entities.stream().map(item->userConverter.convertEntityToDTO(item))
												.collect(Collectors.toList());
	   for(UserDTO staff : staffs) {
		   if(userRepository.checkStaffmanagerBuilding(staff.getId(), buildingId)) {
			   staff.setChecked("checked");
		   }else {
			   staff.setChecked("");
		   }
	   }
		return staffs;
	}
	
	
	

}
