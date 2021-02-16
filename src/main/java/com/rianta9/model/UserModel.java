package com.rianta9.model;

import java.sql.Timestamp;

public class UserModel extends AbstractModel{
	private String userName;
	private String fullName;
	private String password;
	private Long roleID;
	private int status;
	
	public UserModel() {
		super();
	}
	
	public UserModel(Long id, Timestamp dateCreated, Timestamp dateModified, String createdBy, String modifiedBy,
			String userName, String fullName, String password, Long roleID, int status) {
		super(id, dateCreated, dateModified, createdBy, modifiedBy);
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.roleID = roleID;
		this.status = status;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
