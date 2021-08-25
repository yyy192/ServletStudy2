package com.bh.b1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();	
	}
	
	
	
	public int memberJoin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		
		//한 번에 쓰는 것도 가능한~
//		memberDTO.setId(request.getParameter("id"));
//		memberDTO.setPw(request.getParameter("pw"));
//		memberDTO.setName(request.getParameter("name"));
//		memberDTO.setPhone(request.getParameter("phone"));
//		memberDTO.setEmail(request.getParameter("email"));
		
//		int result = memberDAO.getJoin(memberDTO);
//		return result;
		
		return memberDAO.getJoin(memberDTO);
		
	}

}
