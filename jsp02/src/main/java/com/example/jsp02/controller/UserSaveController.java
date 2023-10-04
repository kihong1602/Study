package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserSaveController implements Controller {
	
	UserService userService;
	
	public UserSaveController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "user-save";
		
		String id = (String) paramMap.get("userID");
		String password = (String) paramMap.get("userPW");
		String name = (String) paramMap.get("userName");
		int postCode = Integer.parseInt(String.valueOf(paramMap.get("postCode")));
		String address = (String) paramMap.get("address");
		String addressDetail = (String) paramMap.get("addressDetail");
		String email = (String) paramMap.get("userEmail");
		String tel = (String) paramMap.get("userTel");
		
		User user = new User.UserBuilder(id).password(password).name(name).postcode(postCode)
				.address(address).addressDetail(addressDetail).email(email).tel(tel).build();
		User saveUser = userService.saveUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("saveUser", saveUser);
		
		return modelView;
	}
}
