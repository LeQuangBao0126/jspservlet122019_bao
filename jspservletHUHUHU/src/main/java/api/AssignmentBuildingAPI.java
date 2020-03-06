package api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.input.AssignmentInput;
import dto.AssignmentBuildingDTO;
import dto.UserDTO;
import service.IAssignmentBuildingService;
import service.IBuildingService;
import service.IUserService;
import service.impl.AssignmentBuildingService;
import service.impl.BuildingService;
import service.impl.UserService;
import utils.HttpUtil;


@WebServlet("/assignment-building")
public class AssignmentBuildingAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBuildingService buildingService = new BuildingService();
	private IUserService userService = new UserService();
	private IAssignmentBuildingService abs = new AssignmentBuildingService();
    public AssignmentBuildingAPI() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		AssignmentInput assignmentInput = HttpUtil.of(request.getReader()).toModel(AssignmentInput.class);
	//buildingId và staffids[2,3,4]
		if(assignmentInput.getStaffIds().length >0) {
			Long buildingId = assignmentInput.getBuildingId();
			for(Long userId : assignmentInput.getStaffIds()) {
				//có id r ..kiem tra nếu nó null thì thim vô..còn có r thì ko làm
				// kiểm tra coi nhan vien có dc giao toà nhà chưa
				UserDTO userDTO = userService.checkUserAssignment(userId, buildingId);
				
				if(userDTO == null) {
					// them vào assignment
					AssignmentBuildingDTO assignmentBuildingdto  = new AssignmentBuildingDTO();
					assignmentBuildingdto.setbuildingId(buildingId);
					assignmentBuildingdto.setStaffId(userId);
					abs.insertAssignmentBuilding(assignmentBuildingdto);
				}else {
					continue;
				}
			}
			
		}
		
	}

}