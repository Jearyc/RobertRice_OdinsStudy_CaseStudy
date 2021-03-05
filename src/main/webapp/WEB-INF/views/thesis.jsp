<!-- this page shows source information and provides the interface for adding relationships to other thesis and sources -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${thesis.thesisId} - ${thesis.thesisDescription}</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<div id = "mainContainer">
	<script src="js/header.js"></script>
	<h1>${thesis.thesisId} - ${thesis.thesisDescription}</h1>
		<form:form action="connectThesisToThesis" method="POST" modelAttribute="tempThesis">
			<h2>Connect Thesis</h2>
			<div>
				<form:input path="thesisDescription" value="${thesis.thesisId}" class="hidden"/>
			</div>
			<div>
				<label>Thesis Id: </label>
				<form:input path="thesisId" />
				<form:errors path="thesisId"/>
			</div>
			<hr>
			<div>
				<input type="submit" value="Add" class="button">
			</div>
		</form:form>
		<form:form action="connectThesisToSource" method="POST" modelAttribute="tempSource">
			<div>
				<form:input path="sourceDescription" value="${thesis.thesisId}" class="hidden"/>
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
		
		<table>
			<tr>
				<td>ID</td>
				<td>Type</td>
				<td>Description</td>
				<td>Relevance</td>
			</tr>
			<c:forEach items="${ttRelationship}" var="thesisId">
				<c:if test="${thesisId.thesisIdOne.thesisId == thesis.thesisId}">
					<tr>
						<td>${thesisId.thesisIdTwo.thesisId}</td>
						<td>Thesis</td>
						<td><a href="thesis?id=${thesisId.thesisIdTwo.thesisId}">${thesisId.thesisIdTwo.thesisDescription}</a></td>
						<td>${thesisId.medianRelevanceScore}</td>
					</tr>
				</c:if>
				<c:if test="${thesisId.thesisIdTwo.thesisId == thesis.thesisId}">
					<tr>
						<td>${thesisId.thesisIdOne.thesisId}</td>
						<td>Thesis</td>
						<td><a href="thesis?id=${thesisId.thesisIdOne.thesisId}">${thesisId.thesisIdOne.thesisDescription}</a></td>
						<td>${thesisId.medianRelevanceScore}</td>
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach items="${tsRelationship}" var="sourceId">
				<tr>
					<td>${sourceId.sourceId.sourceId}</td>
					<td>Source</td>
					<td><a href="source?id=${sourceId.sourceId.sourceId}">${sourceId.sourceId.sourceDescription}</a></td>
					<td>${sourceId.medianRelevanceScore}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>