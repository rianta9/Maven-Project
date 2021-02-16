package com.rianta9.model;

import java.sql.Timestamp;

public abstract class AbstractModel {
	private Long id;
	private Timestamp dateCreated;
	private Timestamp dateModified;
	private String createdBy;
	private String modifiedBy;
	
	public AbstractModel() {
		
	}
	
	public AbstractModel(Long id, Timestamp dateCreated, Timestamp dateModified, String createdBy, String modifiedBy) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}


	public Long getID() {
		return id;
	}


	public void setID(Long id) {
		this.id = id;
	}


	public Timestamp getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Timestamp getDateModified() {
		return dateModified;
	}


	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
