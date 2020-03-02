package service.impl;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import api.output.BuildingTypeOutput;
import builder.BuildingSearchBuilder;
import converter.BuildingConverter;
import dto.BuildingDTO;
import entity.BuildingEntity;
import enums.BuildingTypeEnum;
import repository.IBuildingRepository;
import repository.IRentAreaRepository;
import repository.impl.BuildingRepository;
import repository.impl.RentAreaRepository;
import service.IBuildingService;

public class BuildingService implements IBuildingService {
	
	private IBuildingRepository buildingRepository = new BuildingRepository();
	private BuildingConverter buildingConverter = new BuildingConverter();
	private IRentAreaRepository rentAreaRepository = new RentAreaRepository();
	
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
				if(!field.getName().startsWith("rentArea") && !field.getName().equals("types") 
						&& !field.getName().equals("staffId") && !field.getName().startsWith("rentCost"))
				{					
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
	//them thằng dto khi chưa có id ..trả ra thằng dto đó có id ..
	@Override
	public BuildingDTO save(BuildingDTO dto) {
		 BuildingEntity entity = buildingConverter.convertDTOToEntity(dto);
		 StringBuilder sbbuildingtype = new StringBuilder("");
		 if(dto.getBuildingTypes()!=null) {
			 for(String item : dto.getBuildingTypes()) {
				 if(sbbuildingtype.length() > 1) {
					 sbbuildingtype.append(",");
				 }
				 sbbuildingtype.append(item);
			 }
		 }
		 entity.setType(sbbuildingtype.toString());
		 String rentAreas = dto.getRentAreas();
		
		 //xử lý trích xuất từ chuỗi 100,200,300 thành 1 mảng rồi lặp..insert toà nhà truoc rồi mới insert rentarea
		 Long id = buildingRepository.insert(entity); // có long rồi
		 String[] arr = rentAreas.split(",");
		 
		 for(String rentArea : arr ) {
			 rentAreaRepository.insert(rentArea,id);
		 }

		BuildingDTO resultDTO =  buildingConverter.convertEntityToDTO(buildingRepository.findById(id)) ;			 
		return	resultDTO;
	}

	
	
	@Override
	public List<BuildingTypeOutput> getBuildingType() {
		List<BuildingTypeOutput> result = new ArrayList<>();
		for(BuildingTypeEnum item : BuildingTypeEnum.values() ) {
			BuildingTypeOutput buildingTypeOutput = new BuildingTypeOutput();
			buildingTypeOutput.setName(item.getEnumValue());
			buildingTypeOutput.setCode(item.toString());
			result.add(buildingTypeOutput);
		}
		return result;
	}
	@Override
	public BuildingDTO update(BuildingDTO updateDto) {
		BuildingDTO Oldbuildingdto = buildingConverter.convertEntityToDTO(buildingRepository.findById(updateDto.getId()));
		updateDto.setCreatedDate(Oldbuildingdto.getCreatedDate());
		updateDto.setCreatedBy(Oldbuildingdto.getCreatedBy());
		updateDto.setModifiededDate(new Timestamp(System.currentTimeMillis()));
		//updateDto.setModifiedBy();
		Long id = buildingRepository.update(buildingConverter.convertDTOToEntity(updateDto));
		
		BuildingDTO resultdto =buildingConverter.convertEntityToDTO(buildingRepository.findById(id)) ;
		return resultdto;
	}
	@Override
	public void delete(Long[] ids) {
		for(Long id : ids) {
			buildingRepository.delete(id);
		}
	}
}
