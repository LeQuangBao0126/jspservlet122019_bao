package enums;

public enum DistrictEnum {
	QUAN_1("Quận 1 "), QUAN_2("Quận 2 "), QUAN_3("Quận 3 "), QUAN_4("Quận 4 "),
	QUAN_5("Quận 5 "), QUAN_6("Quận 6 "), QUAN_7("Quận 7 "), QUAN_8("Quận 8 "),
	QUAN_9("Quận 9 "), QUAN_10("Quận 10 "), QUAN_11("Quận 11 "), QUAN_12("Quận 12");
	private String value;

	private DistrictEnum(String v) {
		this.value = v;
	}

	public String getEnumValue() {
		return this.value;
	}

}
