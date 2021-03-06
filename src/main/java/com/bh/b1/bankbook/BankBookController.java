package com.bh.b1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankBookController {

	private BankBookDAO bankBookDAO;
	
	public BankBookController() {
		bankBookDAO = new BankBookDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("==");
		System.out.println("BankBook Controller 실행");
		
		String path = "";
		String uri = request.getRequestURI();
		
		String [] uris = uri.split("/");
		
		path = uris[3];
		
/**     LIST                                            **/
		if(path.equals("bankbookList.do")) {
			System.out.println("상품 목록");
			ArrayList<BankBookDTO> ar = bankBookDAO.getList();

			//for(초기식;조건식;증감식)
//			for(int i=0;i<ar.size();i++) {
//			System.out.println("BOOKNUMBER : "+ar.get(i).getBookNumber());
//			System.out.println("BOOKNAME   : "+ar.get(i).getBookName());
//			System.out.println("BOOKRATE   : "+ar.get(i).getBookRate());
//			System.out.println("BOOKUSE    : "+ar.get(i).getBookUse());
//			System.out.println("=======================");
//		}
 
		//for(모은타입명 변수명:컬렉션참조변수명)
		for(BankBookDTO bankBookDTO:ar) {
			System.out.println("BOOKNUMBER : "+bankBookDTO.getBookNumber());
			System.out.println("BOOKNAME   : "+bankBookDTO.getBookName());
			System.out.println("BOOKRATE   : "+bankBookDTO.getBookRate());
			System.out.println("BOOKUSE    : "+bankBookDTO.getBookUse());
			System.out.println("=======================");
		}
			
		request.setAttribute("list", ar);
		RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
		try {
			view.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
/**     INSERT                                             **/
		}else if(path.equals("bankbookInsert.do")) {
			System.out.println("상품 등록");
			
			String method = request.getMethod();
			System.out.println("METHOD : "+method);
			
			if(method.equals("POST")) {

				String bookName = request.getParameter("bookName");
				String bookRate = request.getParameter("bookRate");
				String bookUse = request.getParameter("bookUse");
				
				BankBookDTO bankbookDTO = new BankBookDTO();
				bankbookDTO.setBookName(bookName);
				bankbookDTO.setBookRate(Double.parseDouble(bookRate));
				bankbookDTO.setBookUse(Integer.parseInt(bookUse));
				
				int result = bankBookDAO.setInsert(bankbookDTO);
				System.out.println(result);
				
//				ArrayList<BankBookDTO> ar = bankBookDAO.getList();
//				request.setAttribute("list", ar);
				
				try {
					response.sendRedirect("./bankbookList.do");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookInsert.jsp");
				
				try {
					view.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} //if-else문 끝
			
				
/**     SELECT                                             **/	
		}else  if(path.equals("bankbookSelect.do")) {
		
			System.out.println("상품 상세조회");
			String num = request.getParameter("bookNumber");
			long booknumber = Long.parseLong(num);
		
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(booknumber);
			
			bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
			
			System.out.println("BOOKNUMBER : "+bankBookDTO.getBookNumber());
			System.out.println("BOOKNAME   : "+bankBookDTO.getBookName());
			
			request.setAttribute("dto", bankBookDTO);
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("그 외 나머지");
		}
	}
}
