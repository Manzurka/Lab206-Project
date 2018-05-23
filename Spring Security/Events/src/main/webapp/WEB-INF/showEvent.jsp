<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><c:out value="${event.name}"/></title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="submit" value="Logout"/>
	</form>
	
		<a href="/events">Dashboard</a>
		
	<h1><c:out value="${event.name}"/></h1>
		<p>Host: <c:out value="${event.host.name}"/></p>
		<p>Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${event.eventDate}"/></p>
		<p>Location: <c:out value="${event.location}"/></p>
		<p>People who are attending this event: <c:out value="${event.guests.size()}"/></p>
			
			<table>
				<tr>
					<th>Name</th>
					<th>Location</th>
				</tr>
				<tbody>	
					<c:forEach var="guest" items="${event.guests}">
				<tr>
					<td><c:out value="${guest.firstName}"/> <c:out value="${guest.lastName}"/></td>
					<td><c:out value="${guest.location}"/> <c:out value="${guest.state}"/></td>
				</tr>
					</c:forEach>
				</tbody>
			</table>
	
	<h1>Message Wall</h1>
			
			<c:forEach var="comment" items="${event.comments}">
				<p><c:out value="${comment.commenter.firstName}"/> says: <c:out value="${comment.text}"/></p>
				<hr>
			</c:forEach>
			
			<p><form:errors path="comment.*"/></p>
			<form:form method="POST" action="/events/${event.id}/addComment" modelAttribute="comment">
			<form:label path="text">Add Comment:</form:label>
			<form:textarea path="text"/>
				
			<input type="submit" value="Submit"/>
			</form:form>
		
</body>
</html>