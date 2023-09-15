package com.example.jsp01.day03;

import com.example.jsp01.day03.member.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "member-form", value = "/member-form")
public class MemberFormController extends HttpServlet {
	
	MemberDao memberDao = new MemberDao();
	static Map<String, String> daoMap = new HashMap<>();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String order = request.getParameter("order");
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		Member member = new Member(userId, userPw, userName, userEmail);
		if (order.equals("insert")) {
			memberDao.insertMember(member);
		}
	}
	
	private static void mapList() {
		daoMap.put("insert", "insertMember");
		daoMap.put("selectName", "selectMemberName");
		daoMap.put("selectId", "selectMemberID");
		daoMap.put("delete", "deleteMember");
	}
	
}
