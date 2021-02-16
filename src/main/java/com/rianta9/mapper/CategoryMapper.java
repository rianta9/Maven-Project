package com.rianta9.mapper;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.rianta9.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			Long id = rs.getLong("id");
			String code = rs.getString("code");
			String name = rs.getNString("name");
			String createdBy = rs.getString("createdby");
			String modifiedBy = rs.getString("modifiedby");
			Timestamp dateCreated = rs.getTimestamp("datecreated");
			Timestamp dateModified = rs.getTimestamp("datemodified");
			return new CategoryModel(id, dateCreated, dateModified, createdBy, modifiedBy, name, code);
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
