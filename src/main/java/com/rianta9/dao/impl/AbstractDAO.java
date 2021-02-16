package com.rianta9.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rianta9.dao.GenericDAO;
import com.rianta9.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String database = "mavenproject";
			String url = "jdbc:mysql://localhost:3306/" + database;
			String username = "root";
			String password = "123456";
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> result = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameter
			setParameter(statement, parameters);
			//execute query
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object[] parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object object = parameters[i];
				if(object instanceof Long) statement.setLong(i+1, (Long)object);
				else if(object instanceof Double) statement.setDouble(i+1, (Double)object);
				else if(object instanceof Integer) statement.setInt(i+1, (Integer)object);
				else if(object instanceof BigDecimal) statement.setBigDecimal(i+1, (BigDecimal)object);
				else if(object instanceof Boolean) statement.setBoolean(i+1, (Boolean)object);
				else if(object instanceof String) statement.setString(i+1, (String)object);
				else if(object instanceof Timestamp) statement.setTimestamp(i+1, (Timestamp)object);
				else if(object instanceof Date) statement.setDate(i+1, (Date)object);
				else System.out.println("Có lỗi dữ liệu ở setParameter() trong AbstractDAO!.(Kiểu dữ liệu)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}
}
