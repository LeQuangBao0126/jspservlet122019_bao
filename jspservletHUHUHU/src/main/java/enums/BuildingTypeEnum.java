package enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng trệt"), NGUYEN_CAN("Nguyên Căn"), NOI_THAT("Nội thất");

	private String value;

	private BuildingTypeEnum(String v) {
		this.value = v;
	}

	public String getEnumValue() {
		return this.value;
	}
}
