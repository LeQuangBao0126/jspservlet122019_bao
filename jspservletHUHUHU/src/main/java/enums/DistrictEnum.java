package enums;

public enum DistrictEnum {
	 QUAN_1("Quận 1 "),
	QUAN_2("Quận 2 "),
	QUAN_3("Quận 3 ");
	
	    private String value;

	    private DistrictEnum(String v) {
	        this.value = v;
	    }
	    public String getEnumValue() {
	    	return this.value;	
	    }
	
}
