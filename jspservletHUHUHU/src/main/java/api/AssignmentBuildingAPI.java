package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.input.AssignmentBuildingInput;
import dto.AssignmentBuildingDTO;
import service.IAssignmentBuildingService;
import service.IBuildingService;
import service.IUserService;
import service.impl.AssignmentBuildingService;
import service.impl.BuildingService;
import service.impl.UserService;
import utils.HttpUtil;


@WebServlet("/api-assignmentbuilding")
public class AssignmentBuildingAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBuildingService buildingService = new BuildingService();
	private IUserService userService = new UserService();
	private IAssignmentBuildingService abservice = new AssignmentBuildingService();
    public AssignmentBuildingAPI() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		AssignmentBuildingInput assignmentInput = HttpUtil.of(request.getReader()).toModel(AssignmentBuildingInput.class);
		
     	//buildingId và staffids[2,3,4]
		Long[] staffIds = assignmentInput.getStaffIds();
		if(staffIds.length > 0) {
			Long buildingId = assignmentInput.getBuildingId();
			//lặp mảng staffid trong database so sánh với mảng ngoài client .
			  Long[] arrStaffInDatabase = abservice.getStaffIdByBuildingid(buildingId);
			 
			  for(Long item : staffIds) {
				  for(int j = 0 ; j< arrStaffInDatabase.length ; j++) {  
					  if(item != arrStaffInDatabase[j]) {
						  abservice.insertStaffByBuildingid(item, buildingId);
					  }else {
						  
					  }					  
				  }			
			  }
			  for(Long id :arrStaffInDatabase ) {
				  
			  }
			//lặp trong mảng client.nếu mảng trong databse ko có phan tử trong client thì them.còn có rồi thì remove			
						
		}
		
	}

}
// cái nào mà staff đang giao thì trong bảng ton tai 1 record , nếu như ở tren giao dien bỏ tích thì phải xoá 
// cái record .. 2 bước
// bước 1 : từ assignmentbuilding sẽ lấy staff quản lý..lấy mảng nhan vien quan lý toà nhà đó.
// sau đó cái mảng gửi về từ client chứa những staff mới .. chạy vòng lặp trong mảng mới  so sánh vs staff trong [] cũ
// nếu nằm trong mảng cũ giữ nguyen ko xoá,nếu ko có trong đó thì thêm vào..
// bước 2 : chạy vòng lặp trong staffId cũ ..so sánh vs cá mới...nếu cũ ko nằm trong mới thì remove trong bảng assignment  đi ..




