package com.example.jsp02.day04.service;

import com.example.jsp02.day04.entity.User;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet resultSet;
	
	public User saveUser(User user) {
		connectDB();
		String id = user.getId();
		String password = user.getPassword();
		String name = user.getName();
		int postCode = user.getPostcode();
		String address = user.getAddress();
		String addressDetail = user.getAddressDetail();
		
		int no = 0;
		String sql = "INSERT INTO USER(id,password,name,postcode,address,address_detail) VALUES(?,?,?,?,?,?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, String.valueOf(postCode));
			ps.setString(5, address);
			ps.setString(6, addressDetail);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("저장 완료");
			} else {
				System.out.println("저장 실패");
			}
			sql = "SELECT no FROM user WHERE ID = ?;";
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				no = resultSet.getInt(1);
			}
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new User.UserBuilder(id).no(no).name(name).build();
	}
	
	public User selectUser(User user) {
		connectDB();
		String id = user.getId();
		User selectUser = null;
		String sql = "SELECT * FROM USER WHERE id = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt(1);
				id = resultSet.getString(2);
				String password = resultSet.getString(3);
				String name = resultSet.getString(4);
				int postcode = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String addressDetail = resultSet.getString(7);
				String regDate = resultSet.getString(8);
				
				selectUser = new User.UserBuilder(id).no(no).password(password).name(name)
						.postcode(postcode)
						.address(address).addressDetail(addressDetail).regDate(regDate).build();
			}
			System.out.println("검색 완료");
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("검색 실패");
		}
		
		return selectUser;
	}
	
	public User removeUser(User user) {
		connectDB();
		String id = user.getId();
		String password = user.getPassword();
		
		String sql = "DELETE FROM USER WHERE ID = ? AND PASSWORD = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ps.executeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
		}
		
		return new User.UserBuilder(id).build();
	}
	
	public List<User> userList() {
		connectDB();
		List<User> userList = new ArrayList<>();
		
		String sql = "SELECT * FROM USER;";
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				int no = resultSet.getInt(1);
				String id = resultSet.getString(2);
				String pw = resultSet.getString(3);
				String name = resultSet.getString(4);
				int postCode = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String addressDetail = resultSet.getString(7);
				String regDate = resultSet.getString(8);
				
				User user = new User.UserBuilder(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).build();
				
				userList.add(user);
			}
			resultSet.close();
			connection.close();
			System.out.println("전체조회 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("전체조회 실패");
		}
		
		return userList;
	}
	
	public String idCheck(User user) {
		connectDB();
		String id = user.getId();
		int result = 0;
		
		String sql = "select count(*) AS count from user where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("count");
			}
			
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("count", result);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}
	
	public void connectDB() {
		String url = "jdbc:mariadb://localhost:3307/example";
		String id = "blanc";
		String password = "1234";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(url, id, password);
			System.out.println("연결성공");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
}
