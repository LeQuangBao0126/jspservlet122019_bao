package service;

import java.util.List;

import dto.UserDTO;

public interface IUserService {
		List<UserDTO> findStaffs(String rolecode);
		//
		boolean checkUserAssignment(Long userId,Long buildingid); // nếu có thì trả ra user đó .ko thì là null;
}
