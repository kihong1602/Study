package com.example.jsp01.day03;

import com.example.jsp01.day03.member.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDao() {
		connectDB();
	}
	
	public void insertMember(Member member) {
		String id = member.getId();
		String pw = member.getPw();
		String name = member.getName();
		String email = member.getEmail();
		
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, email);
			
			int r = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectMemberName(String name) {
	}
	
	public void selectMemberID(String id) {
	
	}
	
	public void deleteMember(String name) {
	
	}
	
	private void connectDB() {
		String url = "jdbc:mariadb:/localhost:3307/member";
		String id = "blanc";
		String pw = "1234";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결완료");
		} catch (SQLException e) {
			System.out.println("DB 연결실패");
			e.printStackTrace();
		}
	}
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 연결성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 연결실패");
		}
	}
}
