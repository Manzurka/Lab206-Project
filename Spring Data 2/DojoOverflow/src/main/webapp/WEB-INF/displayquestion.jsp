<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Question Profile</title>
</head>
<body>
	<h1><c:out value="${question.getQuestion()}"/></h1>
	
	<h2>Tags: 
	<c:forEach var="tag" items="${question.getTags()}">
	<c:out value="${tag.getSubject()}"/>
	</c:forEach></h2>
	
	<table>
		<thead>
			<th>Answers</th>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${question.getAnswers().size()>0}">
					<c:forEach var="a" items="${question.getAnswers()}">
						<tr>
							<td><c:out value="${a.getAnswer()}"/></td>
						</tr>
					</c:forEach>
				</c:when>
					<c:otherwise>
						<tr>
							<td>Want to answer? Post your answer below.</td>
						</tr>
					</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
		<h2>Add your answer:</h2>
		<form:form action="/answer/create" modelAttribute="a" method="post">
		<p><form:label path="answer">Answer:
		<form:errors path="answer"/>
		<form:textarea path="answer"></form:textarea>
		</form:label></p>
		
			<input type="hidden" name="question" value="${question.getId()}"/>
			<input type="submit" value="Answer it!">
			
		</form:form>
		<a href="/">Home</a>
</body>
</html>