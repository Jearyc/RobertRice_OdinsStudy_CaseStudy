<!-- this is the home page.  From here users can create new sources and thesis while also viewing the ones that already exist. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
	<div id = "mainContainer">
		<script src="js/header.js"></script>
		<h1>Home Page</h1>
		<form:form action="addThesis" method="POST" modelAttribute="thesis">
			<h2>Add Thesis</h2>
			<div>
				<label>Thesis Description: </label>
				<form:input path="thesisDescription" />
				<form:errors path="thesisDescription"/>
			</div>
			<hr>
			<div>
				<input type="submit" value="Add" class="button">
			</div>
		</form:form>
			
		<form:form action="addSource" method="POST" modelAttribute="source">
			<h2>Add Source</h2>
			<div>
				<label>Source Description: </label>
				<form:input path="sourceDescription" />
				<form:errors path="sourceDescription"/>
			</div>
			<hr>
			<div>
				<input type="submit" value="Add" class="button">
			</div>
		</form:form>
		<table>
			<tr>
				<td>ID</td>
				<td>Type</td>
				<td>Description</td>
			</tr>
			<c:forEach items="${allThesis}" var="thesis">
				<tr>
					<td>${thesis.thesisId}</td>
					<td>Thesis</td>
					<td><a href="thesis?id=${thesis.thesisId}">${thesis.thesisDescription}</a></td>
				</tr>
			</c:forEach>
			<c:forEach items="${allSource}" var="source">
				<tr>
					<td>${source.sourceId}</td>
					<td>Source</td>
					<td><a href="source?id=${source.sourceId}">${source.sourceDescription}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>