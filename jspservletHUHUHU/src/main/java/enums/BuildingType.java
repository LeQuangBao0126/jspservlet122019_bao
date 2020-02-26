package enums;

public enum BuildingType {
	TANG_TRET("Tầng trệt"), NGUYEN_CAN("Nguyên Căn"), NOI_THAT("Nội thất");

	private String value;

	private BuildingType(String v) {
		this.value = v;
	}

	public String getEnumValue() {
		return this.value;
	}
}
