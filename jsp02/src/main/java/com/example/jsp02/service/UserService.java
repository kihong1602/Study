package com.example.jsp02.service;

import com.example.jsp02.entity.User;
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
		String email = user.getEmail();
		String tel = user.getTel();
		
		int no = 0;
		String sql = "INSERT INTO USER(id,password,name,postcode,address,address_detail,email,tel) VALUES(?,?,?,?,?,?,?,?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, String.valueOf(postCode));
			ps.setString(5, address);
			ps.setString(6, addressDetail);
			ps.setString(7, email);
			ps.setString(8, tel);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("저장 완료");
			} else {
				System.out.println("저장 실패");
			}
			sql = "SELECT * FROM user WHERE ID = ?;";
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				no = resultSet.getInt("NO");
			}
			closeDB();
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
			
			closeDB();
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
			closeDB();
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
				String email = resultSet.getString(9);
				String tel = resultSet.getString(10);
				
				User user = new User.UserBuilder(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).email(email).tel(tel).build();
				
				userList.add(user);
			}
			closeDB();
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
		
		String sql = "SELECT count(*) AS count FROM USER WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("count");
			}
			
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("count", result);
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	public Map<String, Object> loginCheck(User user) {
		connectDB();
		boolean check = false;
		Map<String, Object> loginMap = new HashMap<>();
		String id = user.getId();
		String pw = user.getPassword();
		String name = "";
		String sql = "SELECT ID, NAME FROM USER WHERE ID = ? AND PASSWORD = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			resultSet = ps.executeQuery();
			
			if (resultSet.next()) {
				check = true;
				id = resultSet.getString(1);
				name = resultSet.getString(2);
			}
			
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		loginMap.put("check", check);
		loginMap.put("userID", id);
		loginMap.put("userName", name);
		return loginMap;
	}
	
	public User checkUser(User user) {
		connectDB();
		String id = user.getId();
		String pw = user.getPassword();
		String name = null;
		int postcode = 0;
		String address = null;
		String addressDetail = null;
		String email = null;
		String tel = null;
		String sql = "SELECT NAME,POSTCODE, ADDRESS,ADDRESS_DETAIL,EMAIL,TEL FROM USER WHERE ID = ? AND PASSWORD = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				name = resultSet.getString("NAME");
				postcode = resultSet.getInt("POSTCODE");
				address = resultSet.getString("ADDRESS");
				addressDetail = resultSet.getString("ADDRESS_DETAIL");
				email = resultSet.getString("EMAIL");
				tel = resultSet.getString("TEL");
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new User.UserBuilder(id).name(name).postcode(postcode).address(address)
				.addressDetail(addressDetail).email(email).tel(tel).build();
	}
	
	public User infoUpdate(User user) {
		connectDB();
		String id = user.getId();
		String name = "";
		String email = user.getEmail();
		String tel = user.getTel();
		int postcode = user.getPostcode();
		String address = user.getAddress();
		String addressDetail = user.getAddressDetail();
		String regDate = "";
		
		String sql = "UPDATE USER SET TEL =?,EMAIL=?,ADDRESS = ?, ADDRESS_DETAIL = ?,POSTCODE = ? WHERE ID = ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, tel);
			ps.setString(2, email);
			ps.setString(3, address);
			ps.setString(4, addressDetail);
			ps.setInt(5, postcode);
			ps.setString(6, id);
			
			int result = ps.executeUpdate();
			if (result <= 0) {
				System.out.println("업데이트 실패");
			} else {
				System.out.println("업데이트 성공");
				sql = "SELECT * FROM USER WHERE ID = ?;";
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				
				resultSet = ps.executeQuery();
				if (resultSet.next()) {
					id = resultSet.getString("ID");
					name = resultSet.getString("NAME");
					email = resultSet.getString("EMAIL");
					tel = resultSet.getString("TEL");
					postcode = resultSet.getInt("POSTCODE");
					address = resultSet.getString("ADDRESS");
					addressDetail = resultSet.getString("ADDRESS_DETAIL");
					regDate = resultSet.getString("REG_DATE");
				}
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new User.UserBuilder(id).name(name).email(email).tel(tel)
				.postcode(postcode)
				.address(address).addressDetail(addressDetail).regDate(regDate).build();
	}
	
	public User adminRemove(int no) {
		connectDB();
		User user = null;
		String sql = "DELETE FROM USER WHERE NO = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, no);
			
			ps.executeUpdate();
			
			sql = "SELECT * FROM USER";
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				no = resultSet.getInt("NO");
				String id = resultSet.getString("ID");
				String name = resultSet.getString("NAME");
				String email = resultSet.getString("EMAIL");
				int postcode = resultSet.getInt("POSTCODE");
				String address = resultSet.getString("ADDRESS");
				String addressDetail = resultSet.getString("ADDRESS_DETAIL");
				String regDate = resultSet.getString("REG_DATE");
				
				user = new User.UserBuilder(id).no(no).name(name).email(email)
						.postcode(postcode).address(address).addressDetail(addressDetail)
						.regDate(regDate).build();
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int adminDelete(int no) {
		connectDB();
		String sql = "DELETE FROM USER WHERE NO = ?";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, no);
			result = ps.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
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
	
	public void closeDB() throws SQLException {
		resultSet.close();
		connection.close();
	}
}
