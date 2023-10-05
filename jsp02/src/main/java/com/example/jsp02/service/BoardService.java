package com.example.jsp02.service;

import com.example.jsp02.entity.Board;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardService {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet resultSet;
	
	public void insertContent(Board board) {
		connectDB();
		String title = board.getTitle();
		String content = board.getContent();
		String password = board.getPassword();
		String name = board.getName();
		String id = board.getId();
		
		String sql = "insert into board (title,name,content,password,id) values (?,?,?,?,?);";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, content);
			ps.setString(4, password);
			ps.setString(5, id);
			
			ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int boardCount() {
		connectDB();
		int result = 0;
		String sql = "SELECT COUNT(*)as count FROM BOARD;";
		try {
			ps = connection.prepareStatement(sql);
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Board> scanAllContent() {
		connectDB();
		List<Board> boardList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOARD;";
		try {
			ps = connection.prepareStatement(sql);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				//no,title,name,regDate,hit
				int no = resultSet.getInt("NO");
				String id = resultSet.getString("ID");
				String title = resultSet.getString("TITLE");
				String name = resultSet.getString("NAME");
				String password = resultSet.getString("PASSWORD");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				
				Board board = new Board.Builder(password).id(id).no(no).title(title).name(name)
						.regDate(regDate).hit(hit).build();
				boardList.add(board);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public ArrayList<Board> paginationContent(int page, int listPerPage) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOARD LIMIT ?,?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, listPerPage);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				//no,title,name,regDate,hit
				int no = resultSet.getInt("NO");
				String id = resultSet.getString("ID");
				String title = resultSet.getString("TITLE");
				String name = resultSet.getString("NAME");
				String password = resultSet.getString("PASSWORD");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				
				Board board = new Board.Builder(password).id(id).no(no).title(title).name(name)
						.regDate(regDate).hit(hit).build();
				boardList.add(board);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public Board viewContent(int no) {
		connectDB();
		Board board = null;
		String sql = "select * from board where no = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, no);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				no = resultSet.getInt("NO");
				String id = resultSet.getString("ID");
				String title = resultSet.getString("TITLE");
				String name = resultSet.getString("NAME");
				String content = resultSet.getString("CONTENT");
				String regDate = resultSet.getString("REG_DATE");
				String password = resultSet.getString("PASSWORD");
				int hit = resultSet.getInt("HIT");
				board = new Board.Builder(password).id(id).no(no).title(title).name(name)
						.content(content)
						.regDate(regDate).hit(hit).build();
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public void increaseHit(int no) {
		connectDB();
		String sql = "UPDATE board SET hit = hit+1 WHERE no= ?; ";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, no);
			
			ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int removeContent(int no, String password) {
		connectDB();
		
		String sql = "SELECT CONTENT FROM BOARD WHERE NO = ? AND PASSWORD = ?;";
		List<String> imgNameList = new ArrayList<>();
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, password);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String content = resultSet.getString("CONTENT");
				String imgFilePattern = "<img src=\"([^\"]+)\"";
				Pattern pattern = Pattern.compile(imgFilePattern);
				Matcher matcher = pattern.matcher(content);
				if (matcher.find()) {
					String imgFilePath = matcher.group(1);
					File imgFile = new File(imgFilePath);
					if (imgFile.exists() && imgFile.delete()) {
						System.out.println("이미지 삭제 완료");
					} else {
						System.out.println("이미지 삭제 실패");
					}
				}
			}
			
			String sql1 = "DELETE FROM BOARD WHERE NO = ? AND PASSWORD = ?;";
			ps = connection.prepareStatement(sql1);
			ps.setInt(1, no);
			ps.setString(2, password);
			result = ps.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int modifiedContent(Board board) {
		connectDB();
		int result = 0;
		int no = board.getNo();
		String title = board.getTitle();
		String content = board.getContent();
		String password = board.getPassword();
		
		String sql = "UPDATE BOARD SET TITLE = ? ,CONTENT = ? , PASSWORD = ? WHERE no =?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, password);
			ps.setInt(4, no);
			
			result = ps.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Board> searchToTitle(String title, int page, int listPerPage) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD WHERE TITLE LIKE ? LIMIT ?,? ;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			ps.setInt(2, page);
			ps.setInt(3, listPerPage);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt("NO");
				String name = resultSet.getString("NAME");
				String password = resultSet.getString("PASSWORD");
				title = resultSet.getString("TITLE");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				Board board = new Board.Builder(password).no(no).name(name).title(title)
						.regDate(regDate).hit(hit).build();
				boardList.add(board);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public ArrayList<Board> searchToName(String name, int page, int listPerPage) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD WHERE NAME LIKE ? LIMIT ?,?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ps.setInt(2, page);
			ps.setInt(3, listPerPage);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt("NO");
				name = resultSet.getString("NAME");
				String password = resultSet.getString("PASSWORD");
				String title = resultSet.getString("TITLE");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				Board board = new Board.Builder(password).no(no).name(name).title(title)
						.regDate(regDate).hit(hit).build();
				boardList.add(board);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public ArrayList<Board> searchToContent(String content, int page, int listPerPage) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD WHERE CONTENT LIKE ? LIMIT ?,?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + content + "%");
			ps.setInt(2, page);
			ps.setInt(3, listPerPage);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt("NO");
				String name = resultSet.getString("NAME");
				String password = resultSet.getString("PASSWORD");
				String title = resultSet.getString("TITLE");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				Board board = new Board.Builder(password).no(no).name(name).title(title)
						.regDate(regDate).hit(hit).build();
				boardList.add(board);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	public ArrayList<Board> searchAll(String searchWord, int page, int listPerPage) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOARD WHERE CONTENT LIKE ? OR NAME LIKE ? OR TITLE LIKE ? LIMIT ?,?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + searchWord + "%");
			ps.setString(2, "%" + searchWord + "%");
			ps.setString(3, "%" + searchWord + "%");
			ps.setInt(4, page);
			ps.setInt(5, listPerPage);
			
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int no = resultSet.getInt("NO");
				String name = resultSet.getString("NAME");
				String password = resultSet.getString("PASSWORD");
				String title = resultSet.getString("TITLE");
				String regDate = resultSet.getString("REG_DATE");
				int hit = resultSet.getInt("HIT");
				Board board = new Board.Builder(password).no(no).name(name).title(title)
						.regDate(regDate).hit(hit).build();
				boardList.add(board);
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public int countSearchToTitle(String word) {
		connectDB();
		int count = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM BOARD WHERE TITLE LIKE ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countSearchToName(String word) {
		connectDB();
		int count = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM BOARD WHERE NAME LIKE ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countSearchToContent(String word) {
		connectDB();
		int count = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM BOARD WHERE CONTENT LIKE ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int countSearchAll(String word) {
		connectDB();
		int count = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM BOARD WHERE TITLE LIKE ? OR NAME LIKE ? OR CONTENT LIKE ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			ps.setString(2, "%" + word + "%");
			ps.setString(3, "%" + word + "%");
			
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
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
