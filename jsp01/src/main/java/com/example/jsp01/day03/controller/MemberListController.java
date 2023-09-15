package com.example.jsp01.day03.controller;

import com.example.jsp01.day03.member.Member;
import com.example.jsp01.day03.member.MemberService;
import com.example.jsp01.day03.view.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MemberListController implements Controller {
	
	private MemberService memberService;
	
	public MemberListController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String viewPath = "/day03/joinMember/member-list.jsp";
		
		ArrayList<Member> memberList = (ArrayList<Member>) memberService.getUserList();
		
		request.setAttribute("memberList", memberList);
		return new MyView(viewPath);
	}
}
