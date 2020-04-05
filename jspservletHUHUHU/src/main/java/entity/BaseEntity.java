package entity;

import java.util.Date;

import anotation.Column;
import anotation.Entity;

@Entity
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
