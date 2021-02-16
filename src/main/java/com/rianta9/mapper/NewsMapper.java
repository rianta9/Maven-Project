package com.rianta9.mapper;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.rianta9.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			Long id = rs.getLong("id");
			String title = rs.getNString("title");
			String thumbnail = rs.getString("thumbnail");
			String shortContent = rs.getNString("shortcontent");
			String content = rs.getNString("content");
			Long categoryID = rs.getLong("categoryId");
			String createdBy = rs.getString("createdby");
			String modifiedBy = rs.getString("modifiedby");
			Timestamp dateCreated = rs.getTimestamp("datecreated");
			Timestamp dateModified = rs.getTimestamp("datemodified");
			int status = rs.getInt("status");
			return new NewsModel(id, dateCreated, dateModified, createdBy, modifiedBy, title, thumbnail, shortContent, content, categoryID, status);
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
