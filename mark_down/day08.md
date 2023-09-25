# Day08

### 게시판 검색기능

- 게시판에 select태그로 검색칸을 만들고, value를 전달해 해당 값에 맞게 쿼리문을 작성, 결과를 출력하는 기능을 구현함


```html
<form action="<c:url value="/board/progress/search"/>" method="post">
                <label>
                    <select name="search">
                        <option value="all">전체</option>
                        <option value="title">제목</option>
                        <option value="name">글쓴이</option>
                        <option value="content">내용</option>
                    </select>
                </label>
                <label>
                    <input type="text" name="searchWord">
                </label>
                <button>검색</button>
            </form>
```


```java
package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.Board;
import com.example.jsp02.service.BoardService;
import java.util.ArrayList;
import java.util.Map;

public class BoardSearchController implements Controller {
	
	BoardService boardService;
	
	public BoardSearchController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "process/search-process";
		String category = paramMap.get("search");
		String searchWord = paramMap.get("searchWord");
		ArrayList<Board> resultBoard = null;
		switch (category) {
			case "title":
				resultBoard = boardService.searchToTitle(searchWord);
				break;
			case "name":
				resultBoard = boardService.searchToName(searchWord);
				break;
			case "content":
				resultBoard = boardService.searchToContent(searchWord);
				break;
			case "all":
				resultBoard = boardService.searchAll(searchWord);
				break;
		}
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("resultBoard", resultBoard);
		
		return modelView;
	}
}
```

```java
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
			closeDB();
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
			closeDB();
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
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	public ArrayList<Board> searchAll(String searchWord) {
		connectDB();
		ArrayList<Board> boardList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOARD WHERE CONTENT LIKE ? OR NAME = ? OR TITLE LIKE ?;";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + searchWord + "%");
			ps.setString(2, searchWord);
			ps.setString(3, "%" + searchWord + "%");
			
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
}
```

---

- 자신이 작성한 게시글에만 수정, 삭제가 가능하게 구현, 한번 게시글 조회수가 오르면 쿠키를 생성해 해당 게시글을 재방문시 조회수 미증가 기능 구현