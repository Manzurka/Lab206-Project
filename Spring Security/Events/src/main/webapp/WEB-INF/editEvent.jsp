<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Event</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="submit" value="Logout" />
	</form>
	
		<a href="/events">Dashboard</a>
		
		<h2>Create an Event</h2>
			<p><form:errors path="event.*"/></p>
	    
	    	<form:form method="POST" action="" modelAttribute="event">
	    	
		    <p><form:label path="name">Name:</form:label>
		    <form:input path="name"/></p>
		    
		    <p><form:label path="eventDate">Date:</form:label>
		    <form:input type="date" path="eventDate"/></p>
		    
		    <p><form:label path="location">Location:</form:label>
		    <form:input path="location"/>
		    <form:select path ="state">
		    	<c:forEach var="state" items="${listOfstates}">
		        <form:option path ="state" value="${state}"/>
		        </c:forEach>
		    </form:select></p>
		    
			<form:hidden path="host" value="${currentUser.getId()}"/>
		    <input type="submit" value="Update"/>
	    	</form:form>
	    	
</body>
</html>