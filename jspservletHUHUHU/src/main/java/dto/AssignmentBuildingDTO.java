package dto;

public class AssignmentBuildingDTO extends BaseDTO {

	private Long buildingId;
	private Long staffId;

	public Long getbuildingId() {
		return buildingId;
	}
	public void setbuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
}
