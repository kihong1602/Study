package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dto.ReplyBoardDTO;
import com.example.jsp02.service.ReplyBoardService;
import java.io.IOException;
import java.util.Map;

public class ReplyBoardViewController implements Controller {
	
	ReplyBoardService replyBoardService;
	
	public ReplyBoardViewController(ReplyBoardService replyBoardService) {
		this.replyBoardService = replyBoardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "view";
		
		int no = Integer.parseInt((String) paramMap.get("no"));
		ReplyBoardDTO replyBoardDTO = replyBoardService.viewPost(no);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("board", replyBoardDTO);
		
		return modelView;
	}
}
