<!-- this page shows source information and provides the interface for adding relationships to other sources and thesis -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${source.sourceId} - ${source.sourceDescription}</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<div id = "mainContainer">
	<script src="js/header.js"></script>
	<h1>${source.sourceId} - ${source.sourceDescription}</h1>
	
	<form:form action="connectSourceToSource" method="POST" modelAttribute="tempSource">
		<h2>Connect Source</h2>
		<div>
			<form:input path="sourceDescription" value="${source.sourceId}" class="hidden"/>
		</div>
		<div>
			<label>Source Id: </label>
			<form:input path="sourceId" />
			<form:errors path="sourceId"/>
		</div>
		<hr>
		<div>
			<input type="submit" value="Add" class="button">
		</div>
	</form:form>
	<form:form action="connectThesisToSource" method="POST" modelAttribute="tempSource">
		<div>
			<form:input path="sourceId" value="${source.sourceId}" class="hidden"/>
		</div>
		<div>
			<label>Thesis Id: </label>
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
			<td>Relevance</td>
		</tr>
		<c:forEach items="${ssRelationship}" var="sourceId">
			<c:if test="${sourceId.sourceIdOne.sourceId == source.sourceId}">
				<tr>
					<td>${sourceId.sourceIdTwo.sourceId}</td>
					<td>Source</td>
					<td><a href="source?id=${sourceId.sourceIdTwo.sourceId}">${sourceId.sourceIdTwo.sourceDescription}</a></td>
					<td>${sourceId.medianRelevanceScore}</td>
				</tr>
			</c:if>
			<c:if test="${sourceId.sourceIdTwo.sourceId == source.sourceId}">
				<tr>
					<td>${sourceId.sourceIdOne.sourceId}</td>
					<td>Source</td>
					<td><a href="source?id=${sourceId.sourceIdOne.sourceId}">${sourceId.sourceIdOne.sourceDescription}</a></td>
					<td>${sourceId.medianRelevanceScore}</td>
				</tr>
			</c:if>
		</c:forEach>
		<c:forEach items="${tsRelationship}" var="thesisId">
			<tr>
				<td>${thesisId.thesisId.thesisId}</td>
				<td>Thesis</td>
				<td><a href="thesis?id=${thesisId.thesisId.thesisId}">${thesisId.thesisId.thesisDescription}</a></td>
				<td>${thesisId.medianRelevanceScore}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>