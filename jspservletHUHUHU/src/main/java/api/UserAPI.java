package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.UserDTO;
import service.IUserService;
import service.impl.UserService;

@WebServlet("/api-user")
public class UserAPI extends HttpServlet {
	//user thì ko có action mà có roleCode : vd Staff hay manager
	private static final long serialVersionUID = 1L;
    private IUserService userService  = new UserService();
    public UserAPI() {
        super();     
    }
    //trả ra 1 danh sách các nhan vien có checked  = checked 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			String action = request.getParameter("action");
			//String roleCode = request.getParameter("rolecode");
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			Long buildingId =Long.parseLong(request.getParameter("buildingId")) ;
			ObjectMapper objectmapper =new ObjectMapper();
			//if(action != null && action.equals("LOAD_STAFF") && roleCode!= null) {
				List<UserDTO> list =  userService.findStaffs("STAFF");
				//kt user có trong bàng giao ko.có thì checked = checked
				for(UserDTO user : list) {
					boolean checkuser = userService.checkUserAssignment(user.getId(),buildingId);
					if(checkuser) {
						user.setChecked("checked");
					}else {
						user.setChecked("");
					}
				}
				objectmapper.writeValue(response.getOutputStream(), list );
		//	}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
