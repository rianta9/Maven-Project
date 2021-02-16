package com.rianta9.model;

import java.sql.Timestamp;

public class NewsModel extends AbstractModel{
	private String title;
	private String thumbnail;
	private String shortContent;
	private String content;
	private Long categoryID;
	private int status;
	
	public NewsModel() {
		super();
	}
	
	public NewsModel(Long id, Timestamp dateCreated, Timestamp dateModified, String createdBy, String modifiedBy,
			String title, String thumbnail, String shortContent, String content, Long categoryID, int status) {
		super(id, dateCreated, dateModified, createdBy, modifiedBy);
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortContent = shortContent;
		this.content = content;
		this.categoryID = categoryID;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
