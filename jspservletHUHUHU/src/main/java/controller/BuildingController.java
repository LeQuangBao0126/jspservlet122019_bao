package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.input.BuildingInput;
import builder.BuildingSearchBuilder;
import dto.BuildingDTO;
import service.IBuildingService;
import service.impl.BuildingService;
import utils.FormUtil;


@WebServlet("/admin-building")
public class BuildingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBuildingService buildingService = new BuildingService();
	
    public BuildingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		
		if(action.equals("search")) {
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
			request.setAttribute("list",result );
			request.getRequestDispatcher("views/admin/home.jsp").forward(request, response);
	}
		
	}

}
