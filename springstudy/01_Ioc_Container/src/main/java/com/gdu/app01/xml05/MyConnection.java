package com.gdu.app01.xml05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	private String driverClassName;
	private String url;
	private String user;
	private String password;
	
	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getconConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 완료");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
