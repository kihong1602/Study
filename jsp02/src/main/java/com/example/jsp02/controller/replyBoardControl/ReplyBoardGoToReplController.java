package com.example.jsp02.controller.replyBoardControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import java.io.IOException;
import java.util.Map;

public class ReplyBoardGoToReplController implements Controller {
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "reply";
		String reGroup = (String) paramMap.get("regroup");
		String reLevel = (String) paramMap.get("relevel");
		String reStep = (String) paramMap.get("restep");
		System.out.println(reGroup + " | " + reLevel + " | " + reStep);
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("regroup", reGroup);
		modelView.getModel().put("relevel", reLevel);
		modelView.getModel().put("restep", reStep);
		
		return modelView;
	}
}
