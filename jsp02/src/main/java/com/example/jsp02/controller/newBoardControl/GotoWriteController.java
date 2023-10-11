package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import java.io.IOException;
import java.util.Map;

public class GotoWriteController implements Controller {
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "write";
		
		ModelView modelView = new ModelView(viewName);
		return modelView;
	}
}
