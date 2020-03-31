package repository.impl;

import dto.RentAreaDTO;
import entity.RentAreaEntity;
import repository.IRentAreaRepository;


public class RentAreaRepository extends SimpleJPArepository<RentAreaEntity> implements IRentAreaRepository {

	@Override
	public void insert(String rentArea,Long buildingId) {
		RentAreaDTO rd = new RentAreaDTO();
		rd.setBuildingId(buildingId);
		rd.setValue(Integer.parseInt(rentArea));
		this.insert(rd);
	}

	@Override
	public void deleteByBuildingId(Long buildingId) {
		String where = " and buildingid = "+buildingId+" ";
		this.deleteByProperty(where);
	}

}
