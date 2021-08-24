<%@page import="com.bh.b1.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List Page</h1>
	
	<table>
		<tr>
			<th>일련번호</th><th>제품명</th><th>이자율</th><th>사용여부(1-O, 0-X)</th>
		</tr>
	<%
	Object obj = request.getAttribute("list");
	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)obj;


	for(BankBookDTO dto:ar) {
	%>
	
	<tr>
		<td><%= dto.getBookNumber() %></td>
		<td><a href="./bankbookSelect.do?bookNumber=<%= dto.getBookNumber()%>"><%= dto.getBookName() %></td>
		<td><%= dto.getBookRate() %></td>
		<td><%= dto.getBookUse() %></td>
	
	</tr>
<%-- <h2>BOOKNUMBER : <%= dto.getBookNumber() %></h2>
	 <h2>BOOKNAME   : <a href="./bankbookSelect.do?bookNumber=<%= dto.getBookNumber()%>"><%= dto.getBookName() %></a></h2>
	 <h2>BOOKRATE   : <%= dto.getBookRate() %></h2>
	 <h2>BOOKUSE    : <%= dto.getBookUse() %></h2>
	 <h2>==</h2> --%>
	
	
	<%	
	}
	%>
	</table>
</body>
</html>