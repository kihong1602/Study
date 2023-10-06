package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dto.ReplyBoardDTO;
import com.example.jsp02.service.ReplyBoardService;
import java.io.IOException;
import java.util.Map;

public class ReplyBoardReplController implements Controller {
	
	ReplyBoardService replyBoardService;
	
	public ReplyBoardReplController(ReplyBoardService replyBoardService) {
		this.replyBoardService = replyBoardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "write";
		
		String id = (String) paramMap.get("id");
		String name = (String) paramMap.get("name");
		String title = (String) paramMap.get("title");
		String content = (String) paramMap.get("content");
		int reGroup = Integer.parseInt((String) paramMap.get("reGroup"));
		int reLevel = Integer.parseInt((String) paramMap.get("reLevel"));
		int reStep = Integer.parseInt((String) paramMap.get("reStep"));
		
		ReplyBoardDTO replyBoardDTO = new ReplyBoardDTO.Builder(id).reLevel(reLevel)
				.reGroup(reGroup).build();
		
		int levelResult = replyBoardService.updateReLevel(replyBoardDTO);
		
		replyBoardDTO.setId(id);
		replyBoardDTO.setName(name);
		replyBoardDTO.setTitle(title);
		replyBoardDTO.setContent(content);
		replyBoardDTO.setReGroup(reGroup);
		replyBoardDTO.setReLevel(reLevel + 1);
		replyBoardDTO.setReStep(reStep + 1);
		int result = replyBoardService.reply(replyBoardDTO);
		ModelView modelView = new ModelView(viewName);
		
		if (result > 0) {
			modelView.setViewName("redirect");
		}
		return modelView;
	}
}
