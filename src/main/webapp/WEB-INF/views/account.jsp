<!-- This is where users can view all the data that is stored on them as well as change or delete that data. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${currentUser.username}</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<div id = "mainContainer">
	<script src="js/header.js"></script>
	<h1>${currentUser.username}</h1>
		<form:form action="changeUserInfo" method="POST" modelAttribute="user">
			<h2>Change Account Info</h2>
			<h2>${errorMessage}</h2>
			<div>
				<label>Username: </label>
				<form:input path="username" value="${currentUser.username}"/>
				<form:errors path="username"/>
			</div>
			<div>
				<label>Email: </label>
				<form:input path="email" value = "${currentUser.email}"/>
				<form:errors path="email"/>
			</div>
			<div>
				<label>Password: </label>
				<form:input type="password" path="password" value=""/>
				<form:errors path="password" />
			</div>
			<hr>
			<div>
				<input type="submit" value="Submit" class="button">
			</div>
		</form:form>
		<form:form action="deleteUser" method="POST">
			<h2>Delete Account</h2>
			<div>
				<label>Delete all data for account ${currentUser.username}? </label>
				<input type="submit" value="Yes">
			</div>
		</form:form>
	</div>
</body>
</html>