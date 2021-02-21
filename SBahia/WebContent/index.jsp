<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<form action="login" method="post">
				<input type="text" placeholder="email" name="email" required	><br>
				<input type="password" placeholder="password" name="password"  minlength="8" required><br>
				<input type="submit" value="Login">
		</form>				
		</div>
</body>
</html>