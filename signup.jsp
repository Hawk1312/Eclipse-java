<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Signup Here</h3>

	<form action="signup" method="POST">
		<input type="text" name="fname" placeholder="Enter Your First Name"/><br><br>
		<input type="text" name="lname" placeholder="Enter Your Last Name"/><br><br>
		<input type="text" name="uname" placeholder="Enter Your Username"/><br><br>
		<input type="text" name="upass" placeholder="Enter Your Password"/><br><br>
		<input type="text" name="umail" placeholder="Enter Your email"/><br><br>
		<input type="submit"/>
	</form><br><br>
	
	<a href="index.jsp">Home Page</a>
</body>
</html>