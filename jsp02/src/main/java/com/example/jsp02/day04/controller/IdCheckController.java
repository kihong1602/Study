package com.example.jsp02.day04.controller;

import com.example.jsp02.day04.entity.User;
import com.example.jsp02.day04.service.UserService;
import com.example.jsp02.day04.view.ModelView;
import java.util.Map;

public class IdCheckController implements Controller {
	
	UserService userService;
	
	public IdCheckController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "id-check";
		
		String id = paramMap.get("userID");
		User user = new User.UserBuilder(id).build();
		String json = userService.idCheck(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("count", json);
		
		return modelView;
	}
}
