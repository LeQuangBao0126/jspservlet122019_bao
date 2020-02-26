package service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import builder.BuildingSearchBuilder;
import converter.BuildingConverter;
import dto.BuildingDTO;
import entity.BuildingEntity;
import repository.IBuildingRepository;
import repository.impl.BuildingRepository;
import service.IBuildingService;

public class BuildingService implements IBuildingService {
	private IBuildingRepository buildingRepository = new BuildingRepository();
	private BuildingConverter buildingConverter = new BuildingConverter();
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
		List<BuildingDTO> results = new ArrayList<>();
		Map<String,Object> params = convertMaptoProperty(builder);
		/*params.put("name", builder.getName());
		params.put("district", builder.getDistrict());
		params.put("numberOfBasement", StringUtils.isNotBlank(builder.getNumberOfBasement()) 
				? Integer.parseInt(builder.getNumberOfBasement()): null );
		params.put("floorArea", StringUtils.isNotBlank(builder.getFloorArea()) 
				? Integer.parseInt(builder.getFloorArea()): null );*/
		
		List<BuildingEntity> entities  = buildingRepository.findAll(params, builder);
		for(BuildingEntity item : entities) {
			BuildingDTO dto = buildingConverter.convertEntityToDTO(item);
			results.add(dto);
		}
		return results;
	}
	private Map<String, Object> convertMaptoProperty(BuildingSearchBuilder builder) {
		Map<String,Object> properties = new HashMap<>();
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field field : fields) {
				if(!field.getName().startsWith("rentArea") && !field.getName().equals("types")){
					field.setAccessible(true);
					if(field.get(builder) instanceof String) {
						properties.put(field.getName().toLowerCase(), field.get(builder));
					}else {
						if(field.get(builder) != null && StringUtils.isNotEmpty((String)field.get(builder))) {
							properties.put(field.getName().toLowerCase(), Integer.parseInt((String)field.get(builder)));	
						}
					}
				}
			}
		}catch(IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return properties;
	}
	@Override
	public void save(BuildingDTO dto) {
		BuildingEntity entity = buildingConverter.convertDTOToEntity(dto);
		buildingRepository.insert(entity);
	}

}
