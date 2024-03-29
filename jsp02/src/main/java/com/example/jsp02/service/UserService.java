package com.example.jsp02.service;

import com.example.jsp02.entity.User;
import com.google.gson.Gson;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
		
		return new User.Builder().id(id).no(no).name(name).build();
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
				int no = resultSet.getInt("NO");
				id = resultSet.getString("ID");
				String pw = resultSet.getString("PASSWORD");
				String name = resultSet.getString("NAME");
				int postCode = resultSet.getInt("POSTCODE");
				String address = resultSet.getString("ADDRESS");
				String addressDetail = resultSet.getString("ADDRESS_DETAIL");
				String regDate = resultSet.getString("REG_DATE");
				String profile = resultSet.getString("PROFILE");
				
				selectUser = new User.Builder().id(id).no(no).password(pw).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).profile(profile).build();
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
		String profile = user.getProfile();
		String sql = "DELETE FROM USER WHERE ID = ? AND PASSWORD = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			int result = ps.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				String uploadDirectory = "C:\\upload";
				String realUploadPath = uploadDirectory;
				System.out.println(realUploadPath + File.separator + profile);
				File profileFile = new File(realUploadPath + File.separator + profile);
				if (profileFile.exists()) {
					profileFile.delete();
				}
			}
			System.out.println("삭제완료");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
		}
		
		return new User.Builder().id(id).build();
	}
	
	public ArrayList<User> userList() {
		connectDB();
		ArrayList<User> userList = new ArrayList<>();
		
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
				
				User user = new User.Builder().id(id).password(pw).no(no).name(name)
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
		String filePath = "";
		String sql = "SELECT ID, NAME,PROFILE FROM USER WHERE ID = ? AND PASSWORD = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			resultSet = ps.executeQuery();
			
			if (resultSet.next()) {
				check = true;
				id = resultSet.getString("ID");
				name = resultSet.getString("NAME");
				filePath = resultSet.getString("PROFILE");
			}
			
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		loginMap.put("check", check);
		loginMap.put("userID", id);
		loginMap.put("userName", name);
		loginMap.put("profile", filePath);
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
		
		return new User.Builder().id(id).name(name).postcode(postcode).address(address)
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
		String profile = user.getProfile();
		String regDate = "";
		
		String sql = "SELECT PROFILE FROM USER WHERE ID = ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				String fileName = resultSet.getString("PROFILE");
				
				String filePath = "C:\\upload";
				String realPath = filePath + File.separator;
				File oldFile = new File(realPath + fileName);
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			
			String sql2 = "UPDATE USER SET TEL =?,EMAIL=?,ADDRESS = ?, ADDRESS_DETAIL = ?,POSTCODE = ?,PROFILE = ? WHERE ID = ?;";
			ps = connection.prepareStatement(sql2);
			
			ps.setString(1, tel);
			ps.setString(2, email);
			ps.setString(3, address);
			ps.setString(4, addressDetail);
			ps.setInt(5, postcode);
			ps.setString(6, profile);
			ps.setString(7, id);
			
			int result = ps.executeUpdate();
			if (result <= 0) {
				System.out.println("업데이트 실패");
			} else {
				System.out.println("업데이트 성공");
				String sql3 = "SELECT * FROM USER WHERE ID = ?;";
				ps = connection.prepareStatement(sql3);
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
					profile = resultSet.getString("PROFILE");
					regDate = resultSet.getString("REG_DATE");
				}
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new User.Builder().id(id).name(name).email(email).tel(tel)
				.postcode(postcode)
				.address(address).addressDetail(addressDetail).regDate(regDate).profile(profile)
				.build();
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
				
				user = new User.Builder().id(id).no(no).name(name).email(email)
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
	
	public ArrayList<User> searchID(String id) {
		connectDB();
		ArrayList<User> userList = new ArrayList<>();
		
		String sql = "SELECT * FROM USER WHERE ID = ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt(1);
				id = resultSet.getString(2);
				String pw = resultSet.getString(3);
				String name = resultSet.getString(4);
				int postCode = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String addressDetail = resultSet.getString(7);
				String regDate = resultSet.getString(8);
				String email = resultSet.getString(9);
				String tel = resultSet.getString(10);
				
				User user = new User.Builder().id(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).email(email).tel(tel).build();
				
				userList.add(user);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public ArrayList<User> searchName(String name) {
		connectDB();
		ArrayList<User> userList = new ArrayList<>();
		
		String sql = "SELECT * FROM USER WHERE NAME LIKE ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt(1);
				String id = resultSet.getString(2);
				String pw = resultSet.getString(3);
				name = resultSet.getString(4);
				int postCode = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String addressDetail = resultSet.getString(7);
				String regDate = resultSet.getString(8);
				String email = resultSet.getString(9);
				String tel = resultSet.getString(10);
				
				User user = new User.Builder().id(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).email(email).tel(tel).build();
				
				userList.add(user);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public ArrayList<User> searchAddress(String address) {
		connectDB();
		ArrayList<User> userList = new ArrayList<>();
		
		String sql = "SELECT * FROM USER WHERE ADDRESS LIKE ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + address + "%");
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt(1);
				String id = resultSet.getString(2);
				String pw = resultSet.getString(3);
				String name = resultSet.getString(4);
				int postCode = resultSet.getInt(5);
				address = resultSet.getString(6);
				String addressDetail = resultSet.getString(7);
				String regDate = resultSet.getString(8);
				String email = resultSet.getString(9);
				String tel = resultSet.getString(10);
				
				User user = new User.Builder().id(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).email(email).tel(tel).build();
				
				userList.add(user);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public ArrayList<User> searchAll(String searchWord) {
		connectDB();
		ArrayList<User> userList = new ArrayList<>();
		
		String sql = "SELECT * FROM USER WHERE ID = ? OR NAME LIKE ? OR ADDRESS LIKE ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, searchWord);
			ps.setString(2, "%" + searchWord + "%");
			ps.setString(3, "%" + searchWord + "%");
			
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
				
				User user = new User.Builder().id(id).password(pw).no(no).name(name)
						.postcode(postCode).address(address).addressDetail(addressDetail)
						.regDate(regDate).email(email).tel(tel).build();
				
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	
	public User userProfileUpdate(String id, String filePath) {
		connectDB();
		User user = null;
		
		String sql = "UPDATE USER SET PROFILE = ? WHERE ID = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, filePath);
			ps.setString(2, id);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("이미지 저장 성공~~");
				sql = "SELECT * FROM USER WHERE ID = ?";
				
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				
				resultSet = ps.executeQuery();
				if (resultSet.next()) {
					int no = resultSet.getInt("NO");
					id = resultSet.getString("ID");
					String pw = resultSet.getString("PASSWORD");
					String name = resultSet.getString("NAME");
					int postCode = resultSet.getInt("POSTCODE");
					String address = resultSet.getString("ADDRESS");
					String addressDetail = resultSet.getString("ADDRESS_DETAIL");
					String regDate = resultSet.getString("REG_DATE");
					String profile = resultSet.getString("PROFILE");
					
					user = new User.Builder().id(id).no(no).password(pw).name(name)
							.postcode(postCode).address(address).addressDetail(addressDetail)
							.regDate(regDate).profile(profile).build();
				}
			} else {
				System.out.println("이미지 저장실패!!!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public String urlParsing(Part profile, String realUploadPath) throws IOException {
		File dir = new File(realUploadPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		String partHeader = profile.getHeader("Content-disposition");
		
		String[] partHeaderArr = partHeader.split("filename=");
		
		String originalFileName = partHeaderArr[1].trim().replace("\"", "");
		System.out.println(realUploadPath);
		if (!originalFileName.isEmpty()) {
			//물리경로
			profile.write(realUploadPath + File.separator + originalFileName);
			//운영체제에 따라 separator 가 달라지므로 삽입해주어야함.
		}
		
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String firstFileName = originalFileName.substring(0, originalFileName.indexOf("."));
		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String strNow = simpleDateFormat.format(now);
		String newFileName = firstFileName + strNow + ext;
		System.out.println(newFileName);
		
		File oldFile = new File(realUploadPath + File.separator + originalFileName);
		File newFile = new File(realUploadPath + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		return newFileName;
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
