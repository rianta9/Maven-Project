package com.rianta9.model;

import java.sql.Timestamp;

public class RoleModel extends AbstractModel{
	private String code;
	private String name;
	
	public RoleModel() {
		super();
	}
	
	public RoleModel(Long id, Timestamp dateCreated, Timestamp dateModified, String createdBy, String modifiedBy,
			String code, String name) {
		super(id, dateCreated, dateModified, createdBy, modifiedBy);
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
