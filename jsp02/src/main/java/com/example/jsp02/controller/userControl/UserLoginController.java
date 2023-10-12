package com.example.jsp02.controller.userControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.alert.SendModal;
import com.example.jsp02.controller.Controller;
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
		
		User user = new User.Builder().id(id).password(pw).build();
		Map<String, Object> loginCheck = userService.loginCheck(user);
		boolean check = (boolean) loginCheck.get("check");
		loginCheck.put("saveID", saveCheck);
		
		ModelView modelView = new ModelView(viewName);
		modelView.getModel().put("loginCheck", loginCheck);
		if (check) {
			SendModal.writeMsg(modelView, "로그인 성공!", "반갑습니다," + id + " 님!");
		} else {
			SendModal.writeMsg(modelView, "로그인실패..", "아이디와 비밀번호가 맞는지 확인해보세용");
		}
		return modelView;
	}
}
