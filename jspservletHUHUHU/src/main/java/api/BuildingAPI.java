package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.input.ArrayIdDelete;
import api.input.BuildingInput;
import api.output.BuildingTypeOutput;
import builder.BuildingSearchBuilder;
import dto.BuildingDTO;
import service.IBuildingService;
import service.impl.BuildingService;
import utils.FormUtil;
import utils.HttpUtil;

@WebServlet("/api-building")
public class BuildingAPI extends HttpServlet {
    //action là search_building , get_building_type giao kèo giữa back end và front end
	private static final long serialVersionUID = 1L;
	private IBuildingService buildingService = new BuildingService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ta sẽ lấy all param và đổ vào buildingInput
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		ObjectMapper objectMapper = new ObjectMapper();
		if(action!= null && action.equals("SEARCH_BUILDING")) {		
			//lấy mấy cái request param -> thành dto
			// còn httputil kia là lấy json -> dto
			BuildingInput buildingInput = FormUtil.toModel(BuildingInput.class, request);
			BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
					.setName(buildingInput.getName())
					.setDistrict(buildingInput.getDistrict())
					.setFloorArea(buildingInput.getFloorArea())
					.setNumberOfBasement(buildingInput.getNumberOfBasement())
					.setRentAreaFrom(buildingInput.getRentAreaFrom())
					.setRentAreaTo(buildingInput.getRentAreaTo())
					.setRentCostFrom(buildingInput.getRentCostFrom())
					.setRentCostTo(buildingInput.getRentCostTo())
					.setStaffId(buildingInput.getStaffId())
					.setTypes(buildingInput.getBuildingTypes())
					.build();
			List<BuildingDTO> result = buildingService.findAll(builder);
			objectMapper.writeValue(response.getOutputStream(), result);	
		}else if(action!= null && action.equals("GET_BUILDING_TYPE")) {
			List<BuildingTypeOutput> result = buildingService.getBuildingType();			
			objectMapper.writeValue(response.getOutputStream(), result);	
		}
		
	}
	//hàm này ok
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		BuildingDTO buildingDto = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		buildingDto = buildingService.save(buildingDto);		
		objectMapper.writeValue(response.getOutputStream(), buildingDto);
	}
	//hàm này còn sai ...
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		BuildingDTO buildingDto = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		 buildingService.update(buildingDto);
		 //request lai trang chủ admin
		 objectMapper.writeValue(response.getOutputStream(), buildingDto);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayIdDelete buildingIds = objectMapper.readValue(request.getReader(),ArrayIdDelete.class);	 
		buildingService.delete(buildingIds.getBuildingIds());
		
	}
}
