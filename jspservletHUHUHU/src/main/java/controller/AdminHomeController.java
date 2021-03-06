package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BuildingDTO;
import enums.BuildingTypeEnum;
import enums.DistrictEnum;
import service.IBuildingService;
import service.impl.BuildingService;

@WebServlet({"/admin-home","/thoat"})
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBuildingService buildingService = new BuildingService();
    
    public AdminHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		List<BuildingDTO> list = buildingService.getAll();
		Map<String, String> mapBuildingtype = new HashMap<>();
		Map<String,String> mapDistrict = new HashMap<>();
		for(BuildingTypeEnum item : BuildingTypeEnum.values()) {
			mapBuildingtype.put(item.toString(), item.getEnumValue());
		}
		for(DistrictEnum item : DistrictEnum.values()) {
			mapDistrict.put(item.toString(), item.getEnumValue());
		}
		request.setAttribute("mapbuildingtype", mapBuildingtype);
		request.setAttribute("mapdistrict", mapDistrict);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/admin/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
