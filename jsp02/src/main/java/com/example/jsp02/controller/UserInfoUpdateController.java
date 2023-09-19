package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.Map;

public class UserInfoUpdateController implements Controller {
	
	UserService userService;
	
	public UserInfoUpdateController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		String viewName = "user-update";
		
		String id = paramMap.get("userID");
		String email = paramMap.get("userEmail");
		String tel = paramMap.get("userTel");
		int postcode = Integer.parseInt(paramMap.get("postCode"));
		String address = paramMap.get("address");
		String addressDetail = paramMap.get("addressDetail");
		
		User user = new User.UserBuilder(id).email(email).tel(tel).postcode(postcode)
				.address(address).addressDetail(addressDetail).build();
		User updateUser = userService.InfoUpdate(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("updateUser", updateUser);
		return modelView;
	}
}
