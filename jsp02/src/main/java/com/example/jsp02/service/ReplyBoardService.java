package com.example.jsp02.service;

import com.example.jsp02.dto.ReplyBoardDTO;
import com.example.jsp02.entity.ReplyBoard;
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
import java.util.List;

public class ReplyBoardService {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet resultSet;
	
	public int writePost(ReplyBoard replyBoard) {
		connectDB();
		int result = 0;
		String sql = "INSERT INTO replyboard(ID,NAME,TITLE,CONTENT,RE_GROUP) VALUES (?,?,?,?,?);";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, replyBoard.getId());
			ps.setString(2, replyBoard.getName());
			ps.setString(3, replyBoard.getTitle());
			ps.setString(4, replyBoard.getContent());
			ps.setInt(5, replyBoard.getReGroup() + 1);    //regroup max찾아서 1증가
			
			result = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<ReplyBoardDTO> PostList() {
		connectDB();
		List<ReplyBoardDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM REPLYBOARD ORDER BY RE_GROUP DESC, RE_LEVEL ASC";
		try {
			ps = connection.prepareStatement(sql);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt("NO");
				String id = resultSet.getString("ID");
				String name = resultSet.getString("NAME");
				String title = resultSet.getString("TITLE");
				String content = resultSet.getString("CONTENT");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				int reGroup = resultSet.getInt("RE_GROUP");
				int reLevel = resultSet.getInt("RE_LEVEL");
				int reStep = resultSet.getInt("RE_STEP");
				int available = resultSet.getInt("AVAILABLE");
				ReplyBoardDTO replyBoardDTO = new ReplyBoardDTO.Builder(id).no(no).name(name)
						.title(title).content(content)
						.regDate(regDate.substring(0, 16)).hit(hit)
						.reGroup(reGroup)
						.reLevel(reLevel).reStep(reStep).available(available).build();
				list.add(replyBoardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ReplyBoardDTO viewPost(int no) {
		connectDB();
		ReplyBoardDTO replyBoardDTO = null;
		
		String sql = "SELECT * FROM REPLYBOARD WHERE NO = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, no);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				String id = resultSet.getString("ID");
				String name = resultSet.getString("NAME");
				String title = resultSet.getString("TITLE");
				String content = resultSet.getString("CONTENT");
				String regDate = resultSet.getString("REG_DATE");
				int reGroup = resultSet.getInt("RE_GROUP");
				int reLevel = resultSet.getInt("RE_LEVEL");
				int reStep = resultSet.getInt("RE_STEP");
				int hit = resultSet.getInt("HIT");
				
				replyBoardDTO = new ReplyBoardDTO.Builder(id).name(name).title(title)
						.content(content).hit(hit).regDate(regDate).reGroup(reGroup)
						.reLevel(reLevel).reStep(reStep).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return replyBoardDTO;
	}
	
	public int updateReLevel(ReplyBoardDTO replyBoardDTO) {
		int result = 0;
		connectDB();
		String sql = "UPDATE REPLYBOARD SET RE_LEVEL = RE_LEVEL+1 WHERE RE_GROUP = ? AND RE_LEVEL > ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, replyBoardDTO.getReGroup());
			ps.setInt(2, replyBoardDTO.getReLevel());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int reply(ReplyBoardDTO replyBoardDTO) {
		connectDB();
		int result = 0;
		String sql = "INSERT INTO replyboard(ID,NAME,TITLE,CONTENT,RE_GROUP,RE_LEVEL,RE_STEP) VALUES (?,?,?,?,?,?,?);";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, replyBoardDTO.getId());
			ps.setString(2, replyBoardDTO.getName());
			ps.setString(3, replyBoardDTO.getTitle());
			ps.setString(4, replyBoardDTO.getContent());
			ps.setInt(5, replyBoardDTO.getReGroup());    //regroup max찾아서 1증가
			ps.setInt(6, replyBoardDTO.getReLevel());
			ps.setInt(7, replyBoardDTO.getReStep());
			result = ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getMaxRegroup() {
		int result = 0;
		connectDB();
		String sql = "SELECT IFNULL(MAX(RE_GROUP),0)AS MAX  FROM REPLYBOARD";
		try {
			ps = connection.prepareStatement(sql);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("MAX");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void sortNo() {
		connectDB();
		String sql = "ALTER TABLE `replyboard` AUTO_INCREMENT=1;\n";
		String sql2 = "SET @COUNT = 0;\n";
		String sql3 = "UPDATE `replyboard` SET no = @COUNT:=@COUNT+1;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.executeQuery();
			ps = connection.prepareStatement(sql2);
			ps.executeQuery();
			ps = connection.prepareStatement(sql3);
			ps.executeQuery();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String urlParsing(Part ckUpload, String realUploadPath) throws IOException {
		
		String partHeader = ckUpload.getHeader("Content-disposition");
		
		String[] partHeaderArr = partHeader.split("filename=");
		
		String originalFileName = partHeaderArr[1].trim().replace("\"", "");
		System.out.println("realUploadPath : " + realUploadPath);
		if (!originalFileName.isEmpty()) {
			//물리경로
			ckUpload.write(realUploadPath + File.separator + originalFileName);
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
