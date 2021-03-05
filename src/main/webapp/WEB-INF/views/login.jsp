<!-- this is the main login page.  From here you can either log in to be able to use the web site or go to the registration page. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<div id = "mainContainer">
	<form action = "login" method="post">
		<h1>Login</h1>
		<div>
			<label>Username:</label>
			<input type="text" name="username">
		</div>
		<div>
			<label>Password:</label>
			<input type="text" name="password">
		</div>
		<div>
			<input type="submit" value="Login" class="button">
		</div>
		<a href = "/register">Register</a>
	</form>
</div>
</body>
</html>