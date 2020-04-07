package service;

public interface IAssignmentBuildingService {
	Long[] getStaffIdByBuildingid(Long id);
	//
	void insertStaffByBuildingid(Long staffid,Long buildingid);
	void deleteStaffByBuildingid(Long staffid,Long buildingid);
	//
	boolean checkStaffManagerBuildingId(Long staffId,Long buildingId);
}
