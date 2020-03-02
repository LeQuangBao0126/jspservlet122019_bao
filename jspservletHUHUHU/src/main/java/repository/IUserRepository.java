package repository;

import java.util.List;

import entity.UserEntity;

public interface IUserRepository extends JPArepository<UserEntity> {
	List<UserEntity> findUserByRole(String rolecode);
	// tìm nhan vien theo id nha nvien và id building
	UserEntity findByIdAndBuildingId(Long userId,Long buildingId);
}
