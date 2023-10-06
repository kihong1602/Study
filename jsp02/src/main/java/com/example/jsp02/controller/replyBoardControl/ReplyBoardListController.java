package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dto.ReplyBoardDTO;
import com.example.jsp02.service.ReplyBoardService;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReplyBoardListController implements Controller {
	
	ReplyBoardService replyBoardService;
	
	public ReplyBoardListController(ReplyBoardService replyBoardService) {
		this.replyBoardService = replyBoardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "board";
		
		List<ReplyBoardDTO> boardDTOList = replyBoardService.PostList();
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("boardList", boardDTOList);
		
		return modelView;
	}
}
