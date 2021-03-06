package dto;

import java.util.Date;

public class BaseDTO {
	private Long id;
	private Date createdDate;
	private Date modifiededDate;
	private String createdBy;
	private String modifiededBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
