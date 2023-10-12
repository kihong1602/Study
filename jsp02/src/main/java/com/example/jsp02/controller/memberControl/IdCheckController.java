package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import java.io.IOException;
import java.util.Map;

public class IdCheckController implements Controller {
	
	UserDAO userDAO;
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "id-check";
		
		String id = (String) paramMap.get("id");
		
		ModelView modelView = new ModelView(viewName);
		
		return modelView;
	}
}
