<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join Page</h1>
	
	<form action="./memberJoin.do" method="post">
		ID <input type="text" name = "id">
		PW <input type="password" name = "pw">
		NAME <input type="text" name = "name">
		PHONE <input type="tel" name = "phone" placeholder="ex) 010-1234-5678">	
		EMAIL <input type="email" name = "email">
		<div>
			<button>JOIN</button>
		</div>
	
	</form>
</body>
</html>