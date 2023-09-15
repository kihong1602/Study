package com.example.jsp01.day03.controller;

import com.example.jsp01.day03.member.Member;
import com.example.jsp01.day03.member.MemberService;
import com.example.jsp01.day03.view.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberInsertController implements Controller {
	
	private MemberService memberService;
	
	public MemberInsertController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String viewPath = "/day03/joinMember/join-save.jsp";
		String id = request.getParameter("userID");
		String password = request.getParameter("userPW");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		
		Member member = new Member(id, password, name, email);
		Member saveMember = memberService.saveMember(member);
		
		request.setAttribute("saveMember", saveMember);
		return new MyView(viewPath);
	}
}
