package service.impl;

import java.util.ArrayList;
import java.util.List;

import api.output.DistrictOutput;
import enums.DistrictEnum;
import service.IDistrictService;

public class DistrictService implements IDistrictService {

	@Override
	public List<DistrictOutput> listDistrict() {
		List<DistrictOutput> list = new ArrayList<>();
		for(DistrictEnum item : DistrictEnum.values()) {
			DistrictOutput district = new DistrictOutput();
			district.setCode(item.toString());
			district.setName(item.getEnumValue());
			list.add(district);
		}			
		return list;
	}

}
