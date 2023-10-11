package com.example.jsp02.controller.newBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import java.io.IOException;
import java.util.Map;

public class GotoReplyController implements Controller {
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "reply";
		
		int reGroup = Integer.parseInt(String.valueOf(paramMap.get("regroup")));
		int reLevel = Integer.parseInt(String.valueOf(paramMap.get("relevel")));
		int reStep = Integer.parseInt(String.valueOf(paramMap.get("restep")));
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("regroup", reGroup);
		modelView.getModel().put("relevel", reLevel);
		modelView.getModel().put("restep", reStep);
		
		return modelView;
	}
}
