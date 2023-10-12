package com.example.jsp02.controller.userControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class IdCheckController implements Controller {
	
	UserService userService;
	
	public IdCheckController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "id-check";
		
		String id = (String) paramMap.get("userID");
		User user = new User.Builder().id(id).build();
		String json = userService.idCheck(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("count", json);
		
		return modelView;
	}
}
