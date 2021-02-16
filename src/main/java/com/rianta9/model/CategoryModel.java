package com.rianta9.model;

import java.sql.Timestamp;

public class CategoryModel extends AbstractModel{
	private String name;
	private String code;
	
	public CategoryModel() {
		super();
	}
	
	public CategoryModel(Long id, Timestamp dateCreated, Timestamp dateModified, String createdBy, String modifiedBy,
			String name, String code) {
		super(id, dateCreated, dateModified, createdBy, modifiedBy);
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
