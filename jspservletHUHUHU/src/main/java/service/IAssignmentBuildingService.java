package service;

public interface IAssignmentBuildingService {
	Long[] getStaffIdByBuildingid(Long id);
	//
	void insertStaffByBuildingid(Long staffid,Long buildingid);
}
