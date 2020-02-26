package zzz;

import java.util.Date;
import java.util.List;

import builder.BuildingSearchBuilder;
import dto.BuildingDTO;
import service.IBuildingService;
import service.impl.BuildingService;

public class EstateApplication {
	public static void main(String[] args) {
		 String name ="aa";
		 String district = "QUAN_1";
		 String[] types = new String[] {"TANG_TRET","NOI_THAT"};
		 String rentAreaFrom ="500";
		 String rentAreaTo ="500";
		 String numberOfBasement = "2";
		 String floorArea ="500";
		 String rentCostFrom = "1";
		 String rentCostTo = "2";
		 Long staffId = 2L;
		 	 
		 BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				 .setName(name)
				// .setDistrict(district)
				// .setFloorArea(floorArea)
				// .setNumberOfBasement(numberOfBasement)
				// .setRentAreaFrom(rentAreaFrom)
				 //.setRentAreaTo(rentAreaTo)
				 //.setRentCostFrom(rentCostFrom)
				 //.setRentCostTo(rentCostTo)
				 //.setTypes(types)
				 //.setStaffId(staffId)
				 .build();
		 IBuildingService buildingService = new BuildingService();
		 List<BuildingDTO> results = buildingService.findAll(builder);
		 System.out.println(results);		 	
	}
	
}
