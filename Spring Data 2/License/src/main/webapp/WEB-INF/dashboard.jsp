<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard | Profile Page</title>
</head>
<body>
	<h1>New Person</h1>
		<form:form action="/person/new" method="post" modelAttribute="person">
			<p><form:label path="firstName">First Name
			<form:errors path="firstName"/>
			<form:input path="firstName"/></form:label></p>
				
			<p><form:label path="lastName">Last Name
			<form:errors path="lastName"/>
			<form:input path="lastName"/></form:label></p>
			
			<input type="submit" value="Create"/>
		</form:form>
</body>
</html>