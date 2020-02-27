package entity;

import java.util.Date;

import anotation.Column;
import anotation.Entity;
import anotation.Table;

@Entity
@Table(name = "user")
public class UserEntity  {
	@Column(name = "username")
	private String userName;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "password")
	private String passWord;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

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
