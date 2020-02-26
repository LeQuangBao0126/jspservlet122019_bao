package repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import builder.BuildingSearchBuilder;
import entity.BuildingEntity;
import repository.IBuildingRepository;

public class BuildingRepository extends SimpleJPArepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public void insert(BuildingEntity entity) {
		super.insert(entity);
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
	


}
