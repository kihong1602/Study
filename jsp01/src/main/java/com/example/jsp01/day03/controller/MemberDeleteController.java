package com.example.jsp01.day03.controller;

import com.example.jsp01.day03.member.Member;
import com.example.jsp01.day03.member.MemberService;
import com.example.jsp01.day03.view.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberDeleteController implements Controller {
	
	private MemberService memberService;
	
	public MemberDeleteController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String viewPath = "/day03/join-member/join-delete.jsp";
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		
		Member member = new Member(id, pw, null, null);
		Member deleteMember = memberService.removeMember(member);
		
		request.setAttribute("deleteMember", deleteMember);
		return new MyView(viewPath);
	}
}
