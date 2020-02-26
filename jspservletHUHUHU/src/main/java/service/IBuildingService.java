package service;

import java.util.List;

import builder.BuildingSearchBuilder;
import dto.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	void save(BuildingDTO dto);
}
