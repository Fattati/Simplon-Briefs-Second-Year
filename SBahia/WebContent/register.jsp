<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="css/style.css"%></style>
<title>Home</title>
</head>
<body>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>S<span>Bahia</span></div>
		</div>
		<br>
		<div class="login">
		       <form action="register" method="post">
				<input type="text" placeholder="username" name="name"><br>
				<p></p>
				<input type="text" placeholder="email" name="email"><br>
				<input type="password" placeholder="password" name="password"><br>
				<input type="submit" value="Register">
				</form>
		</div>
</body>
</html>