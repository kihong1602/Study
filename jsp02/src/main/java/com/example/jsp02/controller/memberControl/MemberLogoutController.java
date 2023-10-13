package com.example.jsp02.controller.memberControl;

import com.example.jsp02.View.ModelView;
import com.example.jsp02.alert.SendModal;
import com.example.jsp02.controller.Controller;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberLogoutController implements Controller {
	
	@Override
	public ModelView process(Map<String, Object> paramMap) throws IOException {
		String viewName = "logout";
		
		HttpSession session = (HttpSession) paramMap.get("session");
		session.removeAttribute("loggedID");
		session.removeAttribute("loggedName");
		session.removeAttribute("filePath");
		
		ModelView modelView = new ModelView(viewName);
		SendModal.writeMsg(modelView, "로그아웃 되었습니다.", "또 방문해주세요!", "/");
		
		return modelView;
	}
}
