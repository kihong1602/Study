package com.example.jsp01.day03.controller;

import com.example.jsp01.day03.member.Member;
import com.example.jsp01.day03.member.MemberService;
import com.example.jsp01.day03.view.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSelectController implements Controller {
	
	private MemberService memberService;
	
	public MemberSelectController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String viewPath = "/day03/join-member/join-select.jsp";
		String id = request.getParameter("userID");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		
		Member member = new Member(id, null, name, email);
		Member selectMember = memberService.getMember(member);
		
		request.setAttribute("selectMember", selectMember);
		return new MyView(viewPath);
	}
}
