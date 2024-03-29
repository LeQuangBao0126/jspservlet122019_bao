package repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.UserEntity;
import repository.EntityManagerFactory;
import repository.IUserRepository;

public class UserRepository extends SimpleJPArepository<UserEntity> implements IUserRepository {

	@Override
	public List<UserEntity> findUserByRole(String rolecode) {
		StringBuilder sql = new StringBuilder("select * from user u");
		sql.append(" inner join user_role ur on u.id = ur.userid ");
		sql.append(" inner join role r on r.id = ur.roleid");
		sql.append(" and r.code = '"+rolecode+"'");
		List<UserEntity> list = new ArrayList<>();
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		ResultSet rs= null;
		try {
			 statement = connection.createStatement();
			 rs = statement.executeQuery(sql.toString());
			 while(rs.next()) {
				 UserEntity entity = new UserEntity();
				 entity.setId(rs.getLong("id"));
				 entity.setUserName(rs.getString("username"));
				 entity.setFullName(rs.getString("fullname"));
				 entity.setPassWord(rs.getString("password"));
				 list.add(entity);
			 }
			 return list;
		} catch (SQLException e) {
			return list;
		}
		
	}

	@Override
	public UserEntity findByIdAndBuildingId(Long userId,Long buildingId) {
		String sql = "select * from user u inner join assignmentbuilding ab on u.id = ab.staffid "
				+ "where u.id = "+userId+" and ab.buildingid = "+buildingId+"";
		if(this.findAll(sql).isEmpty()) {
			return null;
		}
		return this.findAll(sql).get(0)  ;
		 
	}

	@Override
	public boolean checkStaffmanagerBuilding(Long staffId, Long buildingId) {
		String sql = "select count(*) from user u inner join assignmentbuilding ab on u.id = ab.staffid "
				+ "where u.id = "+staffId+" and ab.buildingid = "+buildingId+"";
		if(this.count(sql) > 0) {
			return true;
		}
		return false;
	}

}
