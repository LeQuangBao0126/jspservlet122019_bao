package api.output;

public class BuildingOutput {
	private String name;
	private String district;
	private String floorArea;
	private String numberOfBasement;
	private String rentAreaFrom;
	private String rentAreaTo;
	private String rentCostFrom;
	private String rentCostTo;
	private String[] types = new String[] {};
	private Long staffId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}
	public String getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(String numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getRentAreaFrom() {
		return rentAreaFrom;
	}
	public void setRentAreaFrom(String rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}
	public String getRentAreaTo() {
		return rentAreaTo;
	}
	public void setRentAreaTo(String rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}
	public String getRentCostFrom() {
		return rentCostFrom;
	}
	public void setRentCostFrom(String rentCostFrom) {
		this.rentCostFrom = rentCostFrom;
	}
	public String getRentCostTo() {
		return rentCostTo;
	}
	public void setRentCostTo(String rentCostTo) {
		this.rentCostTo = rentCostTo;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
}
