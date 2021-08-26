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
	
	<!-- EL표현 사용 -->
	<h3>BookNumber : ${dto.bookNumber}</h3>
	<h3>BookName : ${requestScope.dto.bookName}</h3>
	<h3>BookRate : ${requestScope.dto.bookRate}</h3>
	<h3>BookUse : ${requestScope.dto.bookUse}</h3>
	<h3>NAME : ${requestScope.name}</h3>
	<h3>COUNT : ${count}</h3>
	<h3>SE : ${sessionScope.se}</h3>
	<h3>SE : ${se}</h3>
	
	
	
</body>
</html>