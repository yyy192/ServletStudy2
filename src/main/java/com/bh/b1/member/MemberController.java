package com.bh.b1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bh.b1.bankbook.BankBookDTO;

public class MemberController {
	private MemberService memberService;
	
	public MemberController() {
		
		memberService = new MemberService();
	}

	
	
	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("==");
		System.out.println("Member Controller 실행");
		
		String path = "";
		
		String uri = request.getRequestURI();
		String [] uris = uri.split("/");
		
		path = uris[3];
		
		//로그인
		if(path.equals("memberLogin.do")) {
			System.out.println("로그인");
			String value = request.getParameter("id");
			System.out.println("ID : "+value);
			String password = request.getParameter("pw");
			System.out.println("PASSWORD : "+password);
		
			
		//회원가입
		}else if(path.equals("memberJoin.do")) {
			System.out.println("회원가입");
			
			String method = request.getMethod();
			System.out.println("METHOD : "+method);
			
			//if-else문 시작
			if(method.equals("GET")) {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				view.forward(request, response);
				
			}else {
				int result = memberService.memberJoin(request, response);
				
				if(result>0) {
					response.sendRedirect("../index.jsp");
				}else {
					response.sendRedirect("./memberJoin.do");
				}
				
			} //if-else문 끝
			
		
			
		//My Page
		}else if(path.equals("memberPage.do")) {
			System.out.println("My Page");
			
			
		//나머지
		}else {
			System.out.println("그 외 나머지");
		}
		
		
	}
}
