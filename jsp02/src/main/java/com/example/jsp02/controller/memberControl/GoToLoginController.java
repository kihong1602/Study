package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import java.io.IOException;
import java.util.Map;

public class GoToLoginController implements Controller {
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "login-process";
		
		return new ModelView(viewName);
	}
}
