package com.example.jsp02.controller.userControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.entity.User;
import com.example.jsp02.service.UserService;
import java.util.ArrayList;
import java.util.Map;

public class UserListSearchController implements Controller {
	
	UserService userService;
	
	public UserListSearchController(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) {
		String viewName = "user-list";
		
		String category = (String) paramMap.get("searchUser");
		String searchWord = (String) paramMap.get("searchWord");
		ArrayList<User> userList = null;
		
		switch (category) {
			case "name":
				userList = userService.searchName(searchWord);
				break;
			case "id":
				userList = userService.searchID(searchWord);
				break;
			case "address":
				userList = userService.searchAddress(searchWord);
				break;
			case "all":
				userList = userService.searchAll(searchWord);
				break;
		}
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("userList", userList);
		
		return modelView;
	}
}
