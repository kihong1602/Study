package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dto.ReplyBoardDTO;
import com.example.jsp02.service.ReplyBoardService;
import java.io.IOException;
import java.util.Map;

public class ReplyBoardUpdateController implements Controller {
	
	ReplyBoardService replyBoardService;
	
	public ReplyBoardUpdateController(ReplyBoardService replyBoardService) {
		this.replyBoardService = replyBoardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "view";
		ModelView modelView = new ModelView(viewName);
		
		int no = Integer.parseInt(String.valueOf(paramMap.get("no")));
		String id = (String) paramMap.get("id");
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		
		ReplyBoardDTO replyBoardDTO = new ReplyBoardDTO.Builder(id).no(no).title(title)
				.content(content).build();
		
		int result = replyBoardService.postUpdate(replyBoardDTO);
		
		if (result != 0) {
			int prevNo = replyBoardService.selectPrevNo(no);
			int nextNo = replyBoardService.selectNextNo(no);
			ReplyBoardDTO prevPost = replyBoardService.selectPrevTitle(prevNo);
			ReplyBoardDTO nextPost = replyBoardService.selectNextTitle(nextNo);
			ReplyBoardDTO viewPost = replyBoardService.viewPost(no);
			modelView.getModel().put("board", viewPost);
			modelView.getModel().put("prevPost", prevPost);
			modelView.getModel().put("nextPost", nextPost);
		}
		
		return modelView;
	}
}
