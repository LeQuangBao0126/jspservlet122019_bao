package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BuildingDTO;
import service.IBuildingService;
import service.impl.BuildingService;

@WebServlet("/admin-home")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBuildingService buildingService = new BuildingService();
    
    public AdminHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BuildingDTO> list = buildingService.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/admin/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
