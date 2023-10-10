package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.service.ReplyBoardService;
import java.io.IOException;
import java.util.Map;

public class ReplyBoardRemoveController implements Controller {
	
	ReplyBoardService replyBoardService;
	
	public ReplyBoardRemoveController(ReplyBoardService replyBoardService) {
		this.replyBoardService = replyBoardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "process/remove";
		
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		int result = replyBoardService.removePost(no);
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("result", result);
		
		return modelView;
	}
}
