package entity;

import java.util.Date;

import anotation.Column;

public class BaseEntity {
	@Column(name = "id")
	private Long id;
	
	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "modifiededdate")
	private Date modifiededDate;

	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "modifiededby")
	private String modifiededBy;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiededDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiededDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiededBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiededBy = modifiedBy;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
