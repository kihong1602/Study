package com.example.jsp02.controller;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.Map;

public class UserInfoUpdateController implements Controller {
	
	UserService userService;
	
	public UserInfoUpdateController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "user-update";
		
		String id = (String) paramMap.get("userID");
		String email = (String) paramMap.get("userEmail");
		String tel = (String) paramMap.get("userTel");
		int postcode = Integer.parseInt((String) paramMap.get("postCode"));
		String address = (String) paramMap.get("address");
		String addressDetail = (String) paramMap.get("addressDetail");
		
		Part profile = (Part) paramMap.get("profile");
		String uploadPath = (String) paramMap.get("uploadPath");
		
		String url = userService.urlParsing(profile, uploadPath);
		User user = new User.UserBuilder(id).email(email).tel(tel).postcode(postcode)
				.address(address).addressDetail(addressDetail).profile(url).build();
		User updateUser = userService.infoUpdate(user);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("updateUser", updateUser);
		return modelView;
	}
}
