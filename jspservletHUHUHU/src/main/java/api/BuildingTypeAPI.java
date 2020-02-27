package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.output.BuildingTypeOutput;
import enums.BuildingTypeEnum;

@WebServlet("/buildingtype")
public class BuildingTypeAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuildingTypeAPI() {
        super();
   
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<BuildingTypeOutput> list = new ArrayList<>();
		for(BuildingTypeEnum item : BuildingTypeEnum.values()) {
			BuildingTypeOutput type = new BuildingTypeOutput();
			type.setCode(item.toString());
			type.setName(item.getEnumValue());
			list.add(type);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(response.getOutputStream(), list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
