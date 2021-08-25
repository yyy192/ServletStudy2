<%@page import="com.bh.b1.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select Page</h1>
	<!-- java영역 -->
	<% 
		String num = request.getParameter("bookNumber");
		Object obj = request.getAttribute("dto");
		BankBookDTO bankBookDTO = (BankBookDTO)obj;
	%>
	
	<h3>BookNumber : <%= num %></h3>
	<h3>BookName : <%= bankBookDTO.getBookName() %></h3>
	<h3>BookRate : <%= bankBookDTO.getBookRate() %></h3>
	<h3>BookUse : <%= bankBookDTO.getBookUse() %></h3>
	
</body>
</html>