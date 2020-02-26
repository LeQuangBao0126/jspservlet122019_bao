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

}
