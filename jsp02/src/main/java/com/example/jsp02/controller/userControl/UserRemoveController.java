package com.example.jsp02.controller.userControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserRemoveController implements Controller {
	
	UserService userService;
	
	public UserRemoveController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "user-delete";
		
		String id = (String) paramMap.get("userID");
		String password = (String) paramMap.get("userPW");
		String filePath = (String) paramMap.get("filePath");
		User user = new User.UserBuilder(id).password(password).profile(filePath).build();
		User removeUser = userService.removeUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("removeUser", removeUser);
		
		return modelView;
	}
}
