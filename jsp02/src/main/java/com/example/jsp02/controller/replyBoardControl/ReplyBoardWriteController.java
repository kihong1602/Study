package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.entity.ReplyBoard;
import com.example.jsp02.service.ReplyBoardService;
import java.io.IOException;
import java.util.Map;

public class ReplyBoardWriteController implements Controller {
	
	ReplyBoardService replyBoardService;
	
	public ReplyBoardWriteController(ReplyBoardService replyBoardService) {
		this.replyBoardService = replyBoardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "process/save-process";
		
		String id = (String) paramMap.get("id");
		String name = (String) paramMap.get("name");
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		int reGroup = replyBoardService.getMaxRegroup();
		
		ReplyBoard board = new ReplyBoard.Builder(id).name(name).title(title).content(content)
				.reGroup(reGroup)
				.build();
		
		int saveResult = replyBoardService.writePost(board);
		
		replyBoardService.sortNo();
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", saveResult);
		return modelView;
	}
}
