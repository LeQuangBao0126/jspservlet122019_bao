package entity;

import anotation.Column;
import anotation.Entity;
import anotation.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity {
	
	@Column(name = "value")
	private Integer value;
	
	@Column(name = "buildingid")
	private Long buildingId;

	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
}
