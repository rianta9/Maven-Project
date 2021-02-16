package com.rianta9.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rianta9.dao.ICategoryDAO;
import com.rianta9.jdbc.MySQL;
import com.rianta9.mapper.CategoryMapper;
import com.rianta9.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> getAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public long insert(CategoryModel category) {
		long result = -1;
		String sql = "insert into category(code, name, createdby) values (?, ?, ?)";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			connect.setAutoCommit(false);
			p = connect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			p.setString(1, category.getCode());
			p.setNString(2, category.getName());
			p.setString(3, category.getCreatedBy());
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
	public boolean update(CategoryModel category) {
		String sql = "update category set code = ?, name = ?, datemodified = ?, modifiedby = ? where id = ?";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		try {
			p = connect.prepareStatement(sql);
			p.setString(1, category.getCode());
			p.setNString(2, category.getName());
			p.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			p.setString(4, category.getModifiedBy());
			p.setLong(5, category.getID());
			if(p.executeUpdate() == 1) return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		String sql = "delete from category where id = ?";
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
	public CategoryModel find(Long id) {
		CategoryModel result = null;
		String sql = "select * from category";
		Connection connect = MySQL.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			p = connect.prepareStatement(sql);
			rs = p.executeQuery();
			if (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getNString("name");
				String createdBy = rs.getString("createdby");
				String modifiedBy = rs.getString("modifiedby");
				Timestamp dateCreated = rs.getTimestamp("datecreated");
				Timestamp dateModified = rs.getTimestamp("datemodified");
				result = new CategoryModel(id, dateCreated, dateModified, createdBy, modifiedBy, name, code);
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

}
