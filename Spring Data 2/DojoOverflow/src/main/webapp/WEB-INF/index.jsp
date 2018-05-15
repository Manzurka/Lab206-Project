<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Question Dashboard</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
		<c:forEach var="question" items="${questions}">
		<tr>
			<td><a href="/question/display/<c:out value="${question.getId()}"/>"><c:out value="${question.getQuestion()}"/></a>
			<td><c:forEach var="tag" items="${question.getTags()}">
				<c:choose>
					<c:when test="${question.getTags().indexOf(tag)==question.getTags().size()-1}">
					<c:out value="${tag.getSubject()}"/>
					</c:when>
						<c:otherwise>
						<c:out value="${tag.getSubject()}"/>
						</c:otherwise>
				</c:choose>
				</c:forEach></td>
		</tr>
		</c:forEach>
	</table>
	<a href="/question/new">New Question</a>
</body>
</html>