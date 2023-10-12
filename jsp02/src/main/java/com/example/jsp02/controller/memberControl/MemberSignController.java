package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import com.example.jsp02.dto.UserDTO;
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
		
		String id = (String) paramMap.get("id");
		String password = (String) paramMap.get("password");
		String name = (String) paramMap.get("name");
		String email = (String) paramMap.get("emil");
		String tel = (String) paramMap.get("tel");
		int postCode = Integer.parseInt(String.valueOf(paramMap.get("postcode")));
		String address = (String) paramMap.get("address");
		String addressDetail = (String) paramMap.get("addressDetail");
//		String profile = userDAO.urlParsing();
		//프로필이미지 추가 해야함
		UserDTO userDto = new UserDTO.Builder().id(id).password(password).name(name).email(email)
				.tel(tel)
				.postcode(postCode).address(address).addressDetail(addressDetail)
//				.profile(profile)
				.build();
		
		int result;
		
		ModelView modelView = new ModelView(viewName);
		
		return modelView;
	}
}
