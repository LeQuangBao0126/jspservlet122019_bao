package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.output.DistrictOutput;
import service.IDistrictService;
import service.impl.DistrictService;


@WebServlet("/api-district")
public class DistrictAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDistrictService districtService = new DistrictService();  

    public DistrictAPI() {
        super();      
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//lấy danh sách districtt
		ObjectMapper objectMapper = new ObjectMapper();
		List<DistrictOutput> listDistrict = districtService.listDistrict();
		objectMapper.writeValue(response.getOutputStream(), listDistrict);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
