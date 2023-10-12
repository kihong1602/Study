package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.NewBoardDAO;
import com.example.jsp02.dto.NewBoardDTO;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewBoardSearchController implements Controller {
	
	NewBoardDAO newBoardDAO;
	
	public NewBoardSearchController(NewBoardDAO newBoardDAO) {
		this.newBoardDAO = newBoardDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "search-board";
		
		int currentPage = (paramMap.get("page") != null) ? Integer.parseInt(
				String.valueOf(paramMap.get("page"))) : 1;
		int recodesPerPage = 10;
		int offset = (currentPage - 1) * recodesPerPage;
		int total = newBoardDAO.getBoardCount();
		int pagination = (int) Math.ceil((double) total / recodesPerPage);
		
		HashMap<String, Object> searchMap = new HashMap<>();
		String category = (String) paramMap.get("category");
		String keyWord = (String) paramMap.get("keyWord");
		searchMap.put("category", category);
		searchMap.put("keyword", keyWord);
		searchMap.put("start", offset);
		searchMap.put("end", recodesPerPage);
		
		List<NewBoardDTO> boardList = newBoardDAO.getSearchBoard(searchMap);
		System.out.println(Arrays.toString(boardList.toArray()));
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("boardList", boardList);
		modelView.getModel().put("pagination", pagination);
		modelView.getModel().put("currentPage", currentPage);
		if (boardList.isEmpty()) {
			modelView.getModel().put("state", "show");
			modelView.getModel().put("topMsg", "검색 결과");
			modelView.getModel().put("bodyMsg", "아무것도 검색되지 않았어요..");
		}
		return modelView;
	}
}
