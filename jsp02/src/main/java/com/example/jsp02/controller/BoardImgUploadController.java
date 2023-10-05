package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.service.BoardService;
import com.google.gson.Gson;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardImgUploadController implements Controller {
	
	BoardService boardService;
	
	public BoardImgUploadController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "process/img-upload";
		
		Part part = (Part) paramMap.get("part");
		String realPath = (String) paramMap.get("uploadPath");
		String fileName = boardService.urlParsing(part, realPath);
		
		Gson gson = new Gson();
		Map<String, Object> imgMap = new HashMap<>();
		
		imgMap.put("url", "/upload/" + fileName);
		imgMap.put("uploaded", true);
		
		String json = gson.toJson(imgMap);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("resultJson", json);
		
		return modelView;
	}
}
