package entity;

import java.util.Date;

import anotation.Column;
import anotation.Entity;
import anotation.Table;



@Entity
@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity {
	@Column(name = "id")
	private Long id;
	
	@Column(name = "buildingid")
	private Long buildingId;
	
	@Column(name = "id")
	private Long staffId;
	
	@Column(name = "id")
	private Date createdDate;
	
	@Column(name = "id")
	private Date modifiededDate;
	
	@Column(name = "id")
	private String createdBy;
	
	@Column(name = "id")
	private String modifiededBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiededDate() {
		return modifiededDate;
	}
	public void setModifiededDate(Date modifiededDate) {
		this.modifiededDate = modifiededDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiededBy() {
		return modifiededBy;
	}
	public void setModifiededBy(String modifiededBy) {
		this.modifiededBy = modifiededBy;
	}
}