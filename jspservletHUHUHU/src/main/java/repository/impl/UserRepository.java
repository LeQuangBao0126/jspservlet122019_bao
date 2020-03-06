package repository.impl;

import java.util.List;

import entity.UserEntity;
import repository.IUserRepository;

public class UserRepository extends SimpleJPArepository<UserEntity> implements IUserRepository {

	@Override
	public List<UserEntity> findUserByRole(String rolecode) {
		StringBuilder sql = new StringBuilder("select * from user u");
		sql.append(" inner join user_role ur on u.id = ur.userid ");
		sql.append(" inner join role r on r.id = ur.roleid");
		sql.append(" and r.code = '"+rolecode+"'");
		return this.findAll(sql.toString());
	}

	@Override
	public UserEntity findByIdAndBuildingId(Long userId, Long buildingId) {
		String sql = "select * from user u inner join assignmentbuilding ab on u.id = ab.staffid "
				+ "where u.id = "+userId+" and ab.buildingid = "+buildingId+"";
		UserEntity userEntity = this.findAll(sql).get(0) != null ? this.findAll(sql).get(0) : null;
		return userEntity;//trả ra list mà lấy cái đầu tiên
	}

}