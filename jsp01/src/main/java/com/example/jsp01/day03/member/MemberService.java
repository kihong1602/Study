package com.example.jsp01.day03.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberService {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet resultSet;
	private int result;
	
	
	public Member saveMember(Member member) {
		connectDB();
		String id = member.getId();
		String pw = member.getPw();
		String name = member.getName();
		String email = member.getEmail();
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, email);
			
			result = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Member(name, id, pw, email);
	}
	
	public Member getMember(Member member) {
		connectDB();
		String id = member.getId();
		String name = member.getName();
		String email = member.getEmail();
		String password = null;
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID = ? AND NAME = ? AND EMAIL = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				password = resultSet.getString("PASSWORD");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Member(name, id, password, email);
	}
	
	public List<Member> getUserList() {
		connectDB();
		
		List<Member> memberList = new ArrayList<>();
		String id;
		String pw;
		String name;
		String email;
		
		String sql = "SELECT * FROM MEMBER;";
		
		try {
			ps = conn.prepareStatement(sql);
			
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				id = resultSet.getString("ID");
				pw = resultSet.getString("PASSWORD");
				name = resultSet.getString("NAME");
				email = resultSet.getString("EMAIL");
				
				Member member = new Member(name, id, pw, email);
				memberList.add(member);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public Member removeMember(Member member) {
		connectDB();
		String name = member.getName();
		String pw = member.getPw();
		
		Member deleteMember = new Member(name, null, null, null);
		String sql = "DELETE FROM MEMBER WHERE NAME = ? AND PASSWORD = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pw);
			
			result = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteMember;
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
