package com.rianta9.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	private static MySQL mySql;
	private static Connection cn;
	private String port = "3306";
	private String database = "mavenproject";
	private String url = "jdbc:mysql://localhost:" + port + "/" + database;
	private String username = "root";
	private String password = "123456";
	
	private MySQL() {
		//DO NOTHING
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, username, password);
			System.out.println("Kết nối csdl thành công!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Kết nối csdl thất bại!");
		}
	}
	
	public static ResultSet getTable(String tb) {
		try {
			String sql = "select * from " + tb;
			PreparedStatement s = cn.prepareStatement(sql);
			return s.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection getConnection() {
		if(mySql == null) {
			mySql = new MySQL();
			mySql.connect();
		}
		if(cn == null) mySql.connect();
		try {
			if(cn.isClosed()) mySql.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
}
