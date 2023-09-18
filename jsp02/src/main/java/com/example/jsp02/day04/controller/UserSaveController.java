package com.example.jsp02.day04.controller;

import com.example.jsp02.day04.View.ModelView;
import com.example.jsp02.day04.entity.User;
import com.example.jsp02.day04.service.UserService;
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
		
		User user = new User.UserBuilder(id).password(password).name(name).postcode(postCode)
				.address(address).addressDetail(addressDetail).build();
		User saveUser = userService.saveUser(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("saveUser", saveUser);
		
		return modelView;
	}
}
