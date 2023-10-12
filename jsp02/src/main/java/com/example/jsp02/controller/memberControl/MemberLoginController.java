package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.alert.SendModal;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import com.example.jsp02.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberLoginController implements Controller {
	
	UserDAO userDao;
	
	public MemberLoginController(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "login";
		String id = (String) paramMap.get("id");
		String password = (String) paramMap.get("password");
		
		UserDTO userDTO = new UserDTO.Builder().id(id).password(password).build();
		
		UserDTO userResponseDTO = userDao.loginCheck(userDTO);
		
		ModelView modelView = new ModelView(viewName);
		if (userResponseDTO != null) {
			HttpSession session = (HttpSession) paramMap.get("session");
			session.setAttribute("loggedID", userResponseDTO.getId());
			session.setAttribute("loggedName", userResponseDTO.getName());
			SendModal.writeMsg(modelView, "로그인 성공!", "반갑습니다. " + userResponseDTO.getId() + " 님!",
					"/");
		} else {
			SendModal.writeMsg(modelView, "로그인 실패..", "ID와 Password를 확인해주세요!", "back");
		}
		
		return modelView;
	}
}
