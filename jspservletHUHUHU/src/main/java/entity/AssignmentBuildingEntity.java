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
	
	@Column(name = "staffid")
	private Long staffId;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "modifiededdate")
	private Date modifiededDate;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "modifiededby")
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
