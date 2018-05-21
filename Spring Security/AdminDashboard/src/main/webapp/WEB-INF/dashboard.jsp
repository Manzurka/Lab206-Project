<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
</head>
<body>
	<h1>Welcome <c:out value="${currentUser.firstName}"/></h1>
	
	<table>
		<tbody>
	    	<tr>
	    		<td>First Name: </td>
	    		<td><c:out value="${currentUser.firstName}"/></td>
	    	</tr>
	    	<tr>
	    		<td>Last Name: </td>
	    		<td><c:out value="${currentUser.lastName}"/></td>
	    	</tr>
	    	<tr>
	    		<td>Email: </td>
	    		<td><c:out value="${currentUser.username}"/></td>
	    	</tr>
	    	<tr>
	    		<td>Sign Up Date: </td>
	    		<td><fmt:formatDate pattern = "MMMM dd, yyyy" value="${currentUser.createdAt}"/></td>
	    	</tr>
	    	<tr>
	    		<td>Last Sign In: </td>
	    		<td><fmt:formatDate pattern = "MMMM dd, yyyy" value="${currentUser.lastSignIn}"/></td>
	    	</tr>
	    </tbody>
	</table>
	
	    <form id="logoutForm" method="POST" action="/logout">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="submit" value="Logout!" />
	    </form>
	    
</body>
</html>