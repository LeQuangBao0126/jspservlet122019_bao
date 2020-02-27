package repository;

import java.util.List;

import entity.UserEntity;

public interface IUserRepository extends JPArepository<UserEntity> {
	List<UserEntity> findUserByRole(String rolecode);
}
