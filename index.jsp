<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.center{
	display:flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

.center h3{
	background-color: skyblue;
	padding: 10px;
	border-radius: 10px;
}
</style>
</head>
<body>
	<div class="center">
	<h3><a href="login.jsp">Login Here</a></h3><br>
	<h3><a href="signup.jsp">Sign up Here</a></h3><br>
	<h3><a href="resetPassword.jsp">Reset Password Here</a></h3><br>
	<h3><a href="allUsers">Display All Users</a></h3><br>
	</div>
</body>
</html>