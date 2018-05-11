<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Index</title>
</head>
<body>
	<c:forEach var="person" items="${persons}">
		<p>First Name: <c:out value="${person.getFirstName()}"/></p>
		<p>Last Name: <c:out value="${person.getLastName()}"/></p>
		<p>License Number: <c:out value="${person.getLicense().getNumber()}"/></p>
		<p>State: <c:out value="${person.getLicense().getState()}"/></p>
		<p>Expiration Date: <c:out value="${person.getLicense().getExpirationDate()}"/></p>
	</c:forEach>
	<a href="/person/new">Create Person</a>
	<a href="/license/new">New License</a>
</body>
</html>