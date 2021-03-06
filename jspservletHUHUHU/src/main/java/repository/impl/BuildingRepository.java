package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import anotation.Table;
import builder.BuildingSearchBuilder;
import entity.BuildingEntity;
import repository.EntityManagerFactory;
import repository.IBuildingRepository;

public class BuildingRepository extends SimpleJPArepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public Long insert(BuildingEntity entity) {
		return super.insert(entity);
	}

	@Override
	public List<BuildingEntity> findAll(Map<String,Object> params,BuildingSearchBuilder builder) {
		StringBuilder sql = new StringBuilder("select * from building b"); 
		if(builder.getStaffId() != null && builder.getStaffId() != -1) {
			sql.append(" inner join assignmentbuilding ab on b.id = ab.buildingid ");
		}
		sql.append(" where 1=1 ");
		sql = this.createSQLfindAllcommon(sql,params);
		sql = createSQLspecial(sql,builder);
		System.out.println(sql.toString());
		return this.findAll(sql.toString());
	}

	private StringBuilder createSQLspecial(StringBuilder sql, BuildingSearchBuilder builder) {
		if(StringUtils.isNotBlank(builder.getRentAreaFrom()) || StringUtils.isNotBlank(builder.getRentAreaTo())) {
			sql.append(" AND EXISTS (select * from rentarea ra where (b.id = ra.buildingid ");
			if(StringUtils.isNotBlank(builder.getRentAreaFrom())) {
				sql.append(" AND ra.value >= "+builder.getRentAreaFrom()+"");
			}
			if(StringUtils.isNotBlank(builder.getRentAreaTo())) {
				sql.append(" AND ra.value <= "+builder.getRentAreaFrom()+"");
			}
			sql.append("))");
		}
		if(builder.getTypes().length >0) {
			sql.append(" and (");
			for(String type : builder.getTypes()) {
				if(type.equals(builder.getTypes()[0])) {
				sql.append(" b.type like '%"+type+"%'");
				}else {
					sql.append(" OR ");
					sql.append(" b.type like '%"+type+"%'");
				}				
			}
			sql.append(")");
		}	
		if(StringUtils.isNotBlank(builder.getRentCostFrom()) ) {
			sql.append(" AND b.rentcost >= "+builder.getRentCostFrom()+"");
		}
		if(StringUtils.isNotBlank(builder.getRentCostTo()) ) {
			sql.append(" AND b.rentcost <= "+builder.getRentCostTo()+"");
		}
		if(builder.getStaffId() != null && builder.getStaffId() != -1) {
			sql.append(" AND ab.staffid = "+builder.getStaffId()+"");
		}
		return sql;
	}

	@Override
	public BuildingEntity findById(Long buildingId) {
		String tableName ="";
		if( BuildingEntity.class.isAnnotationPresent(Table.class)) {
			tableName = BuildingEntity.class.getAnnotation(Table.class).name();
		}
		String sql = "select * from "+tableName;
		String where = " where "+tableName+".id = "+buildingId;
		List<BuildingEntity> list = super.findAll(sql, where);
		return list.get(0);
	}

	@Override
	public void update(BuildingEntity entity) {
		super.update(entity);
	}

	@Override
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	public List<BuildingEntity> getListBuilding() {
		String sql = "select * from building";
		return this.findAll(sql);
	}

	@Override
	public void deleteWithTransaction(Long[] ids) {	
		Connection conn = null;
		Statement statement =null;
		//khi delete thì ta sẽ delete bên n trước bên 1 sau
		try {
			conn =  EntityManagerFactory.getConnection();
			statement = conn.createStatement();
			conn.setAutoCommit(false);
			for(Long id : ids) {
				String sql1 = "delete from rentarea where buildingid = "+id+" ";
				statement.executeUpdate(sql1);
				String sql2 = "delete from assignmentbuilding where buildingid = "+id+" ";
				statement.executeUpdate(sql2);
				String sql3 = "delete from building where id = "+id+" ";
				statement.executeUpdate(sql3);				
			}
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	


}
