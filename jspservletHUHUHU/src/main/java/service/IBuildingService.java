package service;

import java.util.List;

import api.output.BuildingTypeOutput;
import builder.BuildingSearchBuilder;
import dto.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	//
	BuildingDTO save(BuildingDTO dto);
	//
	List<BuildingTypeOutput> getBuildingType();
	//
	BuildingDTO update(BuildingDTO dto);
	//
	void delete(Long[] ids);
	//
	
}
