package com.rianta9.model;

import java.sql.Timestamp;

public class CommentModel extends AbstractModel{
	private String content;
	private Long newsID;
	private Long commentFor;
	
	public CommentModel() {
		super();
	}
	
	public CommentModel(Long id, Timestamp dateCreated, Timestamp dateModified, String createdBy, String modifiedBy,
			String content, Long newsID, Long commentFor) {
		super(id, dateCreated, dateModified, createdBy, modifiedBy);
		this.content = content;
		this.newsID = newsID;
		this.commentFor = commentFor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getNewsID() {
		return newsID;
	}

	public void setNewsID(Long newsID) {
		this.newsID = newsID;
	}

	public Long getCommentFor() {
		return commentFor;
	}

	public void setCommentFor(Long commentFor) {
		this.commentFor = commentFor;
	}
	
	
}
