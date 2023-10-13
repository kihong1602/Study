package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.alert.SendModal;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import com.example.jsp02.dto.UserDTO;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.Map;

public class MemberSignController implements Controller {
	
	UserDAO userDAO;
	
	public MemberSignController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "sign";
		
		Part profile = (Part) paramMap.get("profile");
		String uploadPath = (String) paramMap.get("uploadPath");
		
		String id = (String) paramMap.get("id");
		String password = (String) paramMap.get("password");
		String name = (String) paramMap.get("name");
		String email = (String) paramMap.get("email");
		String tel = (String) paramMap.get("tel");
		int postCode = Integer.parseInt(String.valueOf(paramMap.get("postcode")));
		String address = (String) paramMap.get("address");
		String addressDetail = (String) paramMap.get("addressDetail");
		String url = userDAO.urlParsing(profile, uploadPath);
		
		UserDTO userDto = new UserDTO.Builder().id(id).password(password).name(name).email(email)
				.tel(tel)
				.postcode(postCode).address(address).addressDetail(addressDetail).profile(url)
				.build();
		
		int result = userDAO.saveUser(userDto);
		
		ModelView modelView = new ModelView(viewName);
		if (result > 0) {
			SendModal.writeMsg(modelView, "회원가입완료!", "환영합니다." + id + "님!", "/");
		} else {
			SendModal.writeMsg(modelView, "오류가 발생했어요..", "Q&A에 문의하세요!", "back");
		}
		
		return modelView;
	}
}
