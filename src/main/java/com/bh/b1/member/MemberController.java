package com.bh.b1.member;

import javax.servlet.http.HttpServletRequest;

public class MemberController {

	public void start(HttpServletRequest request) {
		
		System.out.println("==");
		System.out.println("Member Controller 실행");
		
		String path = "";
		
		String uri = request.getRequestURI();
		String [] uris = uri.split("/");
		
		path = uris[3];
		
		if(path.equals("memberLogin.do")) {
			System.out.println("로그인");
			String value = request.getParameter("id");
			System.out.println("ID : "+value);
			String password = request.getParameter("pw");
			System.out.println("PASSWORD : "+password);
			
		}else if(path.equals("memberJoin.do")) {
			System.out.println("회원가입");
		}else if(path.equals("memberPage.do")) {
			System.out.println("My Page");
		}else {
			System.out.println("그 외 나머지");
		}
		
		
	}
}
