package com.example.jsp02.service;

import com.example.jsp02.entity.Board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "DELETE FROM BOARD WHERE NO = ? AND PASSWORD = ?;";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
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
	
	public ArrayList<Board> searchToTitle(String title) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD WHERE TITLE LIKE ?;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public ArrayList<Board> searchToName(String name) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD WHERE NAME = ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public ArrayList<Board> searchToContent(String content) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "SELECT * FROM BOARD WHERE CONTENT LIKE ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + content + "%");
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	public ArrayList<Board> searchAll(String searchWord){
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOARD WHERE CONTENT LIKE ? OR NAME = ? OR TITLE LIKE ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,"%"+searchWord+"%");
			ps.setString(2,searchWord);
			ps.setString(3,"%"+searchWord+"%");
			
			resultSet = ps.executeQuery();
			while(resultSet.next()){
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
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
