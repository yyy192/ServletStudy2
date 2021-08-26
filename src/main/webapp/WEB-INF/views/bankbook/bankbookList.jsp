<%@page import="com.bh.b1.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link href="../css/list.css" rel="stylesheet">
	</head>
	<body>
		<h1>BankBook List Page BY JSTL</h1>
		
		
		<table id="t3">
			<tr>
				<th id="t1">일련번호</th><th class="c1">제품명</th><th class="c1">이자율</th><th class="c1">판매여부(1-O, 0-X)</th><th id="t2">Status</th>
			</tr>
		
			<c:forEach items="${list}" var="dto" varStatus="i">
				<tr>
					<td id="t1">${dto.bookNumber}</td>
					<td class="c1"><a href="./bankbookSelect.do?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
					<td class="c1">${dto.bookRate}</td>
					<td class="c1">${dto.bookUse}</td>
					<td id="t2">
						<p>현재 아이템 : ${i.current}</p>
						<p>인덱스 번호 : ${i.index }</p>
						<p>카운트 번호 : ${i.count }</p>
						<p>처음 인가요 : ${i.first }</p>
						<p>마지막이니? : ${i.last }</p>
					</td>
				</tr>
				
			</c:forEach>
		
		</table>
		
		<div>
			<c:forEach begin="1" end="10" step="1" var="num" varStatus="i">
				<button>${num} : ${i.begin} : ${i.end} : ${i.step}</button>
			</c:forEach>
		</div>
		
	
		<a href="./bankbookInsert.do">Write</a>
	</body>
</html>