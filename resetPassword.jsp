<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Reset Password Here</h3>
	
	<form action="resetPassword" method="POST">
		<input type="text" name="uname" placeholder="Enter Your Username"/><br><br>
		<input type="text" name="upassold" placeholder="Enter Your Current Password"/><br><br>
		<input type="text" name="upassnew" placeholder="Enter Your New Password"/><br><br>
		<input type="submit"/>
	</form><br><br>
	
	<a href="index.jsp">Home Page</a>
</body>
</html>