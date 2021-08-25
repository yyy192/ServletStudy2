package com.bh.b1;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bh.b1.bankbook.BankBookController;
import com.bh.b1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberController memberController;
	private BankBookController bankBookController;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
        
        memberController = new MemberController();
        bankBookController = new BankBookController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==");
		System.out.println("Front Controller 실행");
		
		String uri = request.getRequestURI();
//		String url = request.getRequestURL().toString();
		System.out.println("URI : " + uri);
//		System.out.println("URL : " + url);
		
		
		String path = "";
		String [] uris = uri.split("/");
		path = uris[2];
		
//		int startindex = request.getContextPath().length();
//		int lastindex = uri.lastIndexOf("/");
//		
//		path = uri.substring(startindex, lastindex);
		System.out.println("Path : "+ path);
		
		if(path.equals("member")) {
			try {
				memberController.start(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("bankbook")) {
			bankBookController.start(request, response);
		}else {
			System.out.println("없는 URL");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
