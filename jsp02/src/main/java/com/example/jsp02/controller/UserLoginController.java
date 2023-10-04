package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserLoginController implements Controller {
	
	UserService userService;
	
	public UserLoginController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "user-login";
		
		String id = (String) paramMap.get("userID");
		String pw = (String) paramMap.get("userPW");
		String saveCheck = (String) paramMap.get("saveID");
		
		User user = new User.UserBuilder(id).password(pw).build();
		Map<String, Object> loginCheck = userService.loginCheck(user);
		
		loginCheck.put("saveID", saveCheck);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("loginCheck", loginCheck);
		return modelView;
	}
}
