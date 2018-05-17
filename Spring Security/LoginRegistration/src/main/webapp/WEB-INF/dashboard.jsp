<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
</head>
<body>
	<h1>Welcome <c:out value="${currentUser.firstName}"></c:out>!</h1>
	
		<p>First Name: <c:out value="${currentUser.firstName}"></c:out></p>
		<p>Last Name: <c:out value="${currentUser.lastName}"></c:out></p>
		<p>Email: <c:out value="${currentUser.username}"></c:out></p>
		<p>Sign up date: <fmt:formatDate pattern="MMMM-dd-yyyy" value="${currentUser.createdAt}"/></p>
		<p>Last sign in: <fmt:formatDate pattern="MMMM-dd-yyyy" value="${logintime}"/></p>
		
	 	<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
</body>
</html>