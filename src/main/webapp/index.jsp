<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Index Page</h1>
	
	<h3>Member</h3>
	<p> <!-- 문단 태그 -->
		<a href="/ServletStudy2/member/memberLogin.do?id=t1&pw=pw1"> <!-- 링크(앵커) 태그 -->Member Login</a><br>
		<a href="./member/memberJoin.do">Member Join</a><br>
		<a href="member/memberPage.do">Member Page</a>
	</p>
	<h3>Bankbook</h3>
	<p>
		<a href="/ServletStudy2/bankbook/bankbookList.do">Bankbook List</a><br>
		<a href="./bankbook/bankbookInsert.do">Bankbook Insert</a><br>
		<a href="bankbook/bankbookSelect.do?bookNumber=5">Bankbook Select</a>
	</p>
	
</body>
</html>