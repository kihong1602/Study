package com.example.jsp02.day04.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	private static final String URL = "jdbc:mariadb://localhost:3307/example";
	private static final String ID = "blanc";
	private static final String PASSWORD = "1234";
	public static Connection connection;
	
	public static void ConnectDB() {
		try {
			connection = DriverManager.getConnection(URL, ID, PASSWORD);
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("DataBase 연결 성공");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DataBase 연결 실패");
		}
	}
	
}
