package service;

import java.util.List;

import dto.UserDTO;

public interface IUserService {
		List<UserDTO> findStaffs(String rolecode);
		//
		UserDTO checkUserAssignment(Long userId,Long buildingId); // nếu có thì trả ra user đó .ko thì là null;
}
