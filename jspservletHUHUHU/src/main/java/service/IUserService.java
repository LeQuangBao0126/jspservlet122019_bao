package service;

import java.util.List;

import dto.UserDTO;

public interface IUserService {
		List<UserDTO> findStaffs(String rolecode);
}
