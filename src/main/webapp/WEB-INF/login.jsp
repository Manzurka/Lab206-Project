<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register</title>
		
	</head>
	<body>

			<h1>Login</h1>
			
			<c:if test="${errorMessage != null}">
	        	<c:out value="${errorMessage}"></c:out>
	    	</c:if>
	    	<form method="POST" action="/login">
		        <p>
		            <label for="username">Email</label>
		            <input type="text" id="username" name="username"/>
		        </p>
		        <p>
		            <label for="password">Password</label>
		            <input type="password" id="password" name="password"/>
		        </p>
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input type="submit" value="Login!"/>
	    	</form>
	 </body>
</html>