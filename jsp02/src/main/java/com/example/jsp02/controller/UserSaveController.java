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
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-save";
		
		String id = paramMap.get("userID");
		String password = paramMap.get("userPW");
		String name = paramMap.get("userName");
		int postCode = Integer.parseInt(paramMap.get("postCode"));
		String address = paramMap.get("address");
		String addressDetail = paramMap.get("addressDetail");
		String email = paramMap.get("userEmail");
		String tel = paramMap.get("userTel");
		
		User user = new User.UserBuilder(id).password(password).name(name).postcode(postCode)
				.address(address).addressDetail(addressDetail).email(email).tel(tel).build();
		User saveUser = userService.saveUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("saveUser", saveUser);
		
		return modelView;
	}
}
