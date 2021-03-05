<!-- This page registers a new user.  only accessable to the login page and redirects back to that page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>

	<form:form action="register" method="POST" modelAttribute="user">
		<h1>Registration Page</h1>
		<h2>${errorMessage}</h2>
		<div>
			<label>Username: </label>
			<form:input path="username" />
			<form:errors path="username"/>
		</div>
		<div>
			<label>Email: </label>
			<form:input path="email" />
			<form:errors path="email"/>
		</div>
		<div>
			<label>Password: </label>
			<form:input path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<input type="submit" value="Register" class="button">
		</div>
		<a href="/login"> Cancel</a>
	</form:form>
</body>
</html>