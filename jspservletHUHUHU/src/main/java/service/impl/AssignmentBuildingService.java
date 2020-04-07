package service.impl;

import java.util.ArrayList;
import java.util.List;

import converter.AssignmentBuildingConverter;
import dto.AssignmentBuildingDTO;
import entity.AssignmentBuildingEntity;
import repository.IAssignmentBuildingRepository;
import repository.IUserRepository;
import repository.impl.AssignmentBuildingRepository;
import repository.impl.UserRepository;
import service.IAssignmentBuildingService;

public class AssignmentBuildingService implements IAssignmentBuildingService {
	private IAssignmentBuildingRepository abrepository = new AssignmentBuildingRepository();
	private IUserRepository userRepository = new UserRepository();
	private AssignmentBuildingConverter converter = new AssignmentBuildingConverter();
	@Override
	public Long[] getStaffIdByBuildingid(Long id) {
	    List<AssignmentBuildingEntity> entity = abrepository.findByBuildingid(id);
	    List<AssignmentBuildingDTO> listdto = new ArrayList<>();
	    for(AssignmentBuildingEntity item : entity) {
	    	AssignmentBuildingDTO dto = converter.convertEntityToDTO(item);
	    	listdto.add(dto);
	    }
	    Long[] staffIds = new Long[listdto.size()];
	    int index = 0;
	   for(AssignmentBuildingDTO item : listdto) {
		   staffIds[index] = item.getStaffId();
		   index++;
	   }
		return staffIds ;
	}
	@Override
	public void insertStaffByBuildingid(Long staffid, Long buildingid) {
		AssignmentBuildingDTO assignmentdto = new AssignmentBuildingDTO();
		assignmentdto.setbuildingId(buildingid);
		assignmentdto.setStaffId(staffid);
		AssignmentBuildingEntity assignmententity = converter.convertDTOToEntity(assignmentdto);
		abrepository.insertStaffByBuildingid(assignmententity);
	}
	@Override
	public void deleteStaffByBuildingid(Long staffid, Long buildingid) {
		abrepository.deleteAssignmentByBuildingId(buildingid, staffid);
	}
	@Override
	public boolean checkStaffManagerBuildingId(Long staffId, Long buildingId) {
		String sql = "select count(*) from user u inner join assignmentbuilding ab on u.id = ab.staffid "
				+ "where u.id = "+staffId+" and ab.buildingid = "+buildingId+"";
		if(userRepository.checkStaffmanagerBuilding(staffId, buildingId)) {
			return true;
		}
		return false;
	}
	
	

}
