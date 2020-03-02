package entity;

import anotation.Column;
import anotation.Entity;
import anotation.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
	@Column(name = "id")
	private Long id ;
	
	@Column(name = "value")
	private Integer value;
	
	@Column(name = "buildingid")
	private Long buildingId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
