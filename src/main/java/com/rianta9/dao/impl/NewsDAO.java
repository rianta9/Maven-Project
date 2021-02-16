package com.rianta9.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rianta9.dao.INewsDAO;
import com.rianta9.jdbc.MySQL;
import com.rianta9.mapper.NewsMapper;
import com.rianta9.model.CategoryModel;
import com.rianta9.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{
	@Override
	public List<NewsModel> getAll() {
		String sql = "select * from news";
		return query(sql, new NewsMapper());
	}

	@Override
	public long insert(NewsModel news) {
		long result = -1;
		String sql = "insert into news(title, thumbnail, shortcontent, content, createdby) values (?, ?, ?, ?, ?)";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			connect.setAutoCommit(false);
			p = connect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			p.setNString(1, news.getTitle());
			p.setString(2, news.getThumbnail());
			p.setNString(3, news.getShortContent());
			p.setNString(4, news.getContent());
			p.setString(5, news.getCreatedBy());
			p.executeUpdate();
			
			rs = p.getGeneratedKeys();
			if(rs.next()) {
				result = rs.getLong(1);
				connect.commit();
			}
			else connect.rollback();
			return result;
		} catch (Exception e) {
			try {
				if(connect != null) connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (connect != null)
					connect.close();
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public Long save(NewsModel newsModel) {
		try {
			String sql = "insert into news(title, thumbnail, shortcontent, content, createdby) values (?, ?, ?, ?, ?)";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(NewsModel news) {
		String sql = "update news set title = ?, thumbnail = ?, shortcontent = ?, content = ?, datemodified = ?, modifiedby = ?, status = ? where id = ?";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		try {
			p = connect.prepareStatement(sql);
			p.setNString(1, news.getTitle());
			p.setString(2, news.getThumbnail());
			p.setNString(3, news.getShortContent());
			p.setNString(4, news.getContent());
			p.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			p.setString(6, news.getModifiedBy());
			p.setLong(7, news.getID());
			p.setInt(8, news.getStatus());
			
			if(p.executeUpdate() == 1) return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		String sql = "delete from news where id = ?";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		try {
			p = connect.prepareStatement(sql);
			p.setLong(1, id);
			if(p.executeUpdate() == 1) return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public NewsModel find(Long id) {
		NewsModel result = null;
		String sql = "select * from news";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			p = connect.prepareStatement(sql);
			rs = p.executeQuery();
			if (rs.next()) {
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
				result = new NewsModel(id, dateCreated, dateModified, createdBy, modifiedBy, title, thumbnail, shortContent, content, categoryID, status);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (connect != null)
					connect.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		List<NewsModel> result = new ArrayList<NewsModel>();
		String sql = "select * from news where categoryid = ?";
		Connection connect = MySQL.getConnection();
		try {
			PreparedStatement p = connect.prepareStatement(sql);
			p.setLong(1, categoryId);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
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
				result.add(new NewsModel(id, dateCreated, dateModified, createdBy, modifiedBy, title, thumbnail, shortContent, content, categoryID, status));
			}
			rs.close();
			p.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	

}
