<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login/Register</title>
	</head>
	<body>
	
		<h1>Login</h1>
    	<form method="POST" action="/login">
	        <p>Email: <input type="text" name="username"/></p>
	        <p>Password: <input type="password" name="password"/></p>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Login"/>
    	</form>
    	
    	<h1>Register</h1>
    	
    		<form:form method="POST" action="/registration" modelAttribute="new_user">
	        
	        <p><form:label path="email"> Email: </form:label>
	            <form:input path="email"/></p>
	        
	        <p><form:label path="firstName">First Name: </form:label>
	            <form:input path="firstName"/></p>
	            
	        <p><form:label path="lastName">Last Name: </form:label>
	            <form:input path="lastName"/></p>
	            
	        <p><form:label path="password">Password: </form:label>
	            <form:password path="password"/></p>
	            
	        <p><form:label path="passwordConfirmation">Password Confirmation: </form:label>
	            <form:password path="passwordConfirmation"/></p>
	            
	        <input type="submit" value="Register"/>
    	
    		</form:form>
    		
	</body>
</html>