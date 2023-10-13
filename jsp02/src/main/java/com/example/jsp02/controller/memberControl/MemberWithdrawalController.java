package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.alert.SendModal;
import com.example.jsp02.controller.Controller;
import com.example.jsp02.dao.UserDAO;
import java.io.IOException;
import java.util.Map;

public class MemberWithdrawalController implements Controller {
	
	UserDAO userDAO;
	
	public MemberWithdrawalController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "withdrawal";
		String id = (String) paramMap.get("id");
		String password = (String) paramMap.get("password");
		String filePath = (String) paramMap.get("filePath");
		boolean isRemove = false;
		int result = userDAO.removeUser(id, password);
		
		ModelView modelView = new ModelView(viewName);
		
		if (result > 0) {
			isRemove = userDAO.removeProfileImg(filePath);
			SendModal.writeMsg(modelView, "회원탈퇴가 완료되었습니다.", "이용해주셔서 감사합니다.", "/");
		}
		if (isRemove) {
			System.out.println(filePath + "삭제완료");
		} else {
			System.out.println(filePath + "삭제 실패");
		}
		
		return modelView;
	}
}
