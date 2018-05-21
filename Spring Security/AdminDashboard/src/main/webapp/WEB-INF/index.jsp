<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login/Register</title>
</head>
<body>
	<c:if test="${logoutMessage != null}">
		<c:out value="${logoutMessage}"></c:out>
	</c:if>
	
		<h1>Login</h1>
		
	<c:if test="${errorMessage != null}">
		<c:out value="${errorMessage}"></c:out>
	</c:if>
	
		<form method="post" action="/">
		
		<p><label for="username">Email: </label>
		<input type="text" id="username" name="username"></p>
		
		<p><label for="password">Password: </label>
		<input type="password" id="password" name="password"></p>
					
		<p><input type="submit" value="Login"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></p>
					
		</form>
		
		<h1>Register</h1>
		
	    <form:form method="post" action="/register" modelAttribute="user">
		
		<p><form:label path="firstName">First Name:
		<form:errors path="firstName"/></form:label>
		<form:input path="firstName"/></p>
		   
		<p><form:label path="lastName">Last Name:
		<form:errors path="lastName"/></form:label>
		<form:input path="lastName" class="full"/></p>
		
		<p><form:label path="username">Email:
		<form:errors path="username"/></form:label>
		<form:input path="username"/></p>
		
		<p><form:label path="password">Password:
		<form:errors path="password"/></form:label>
		<form:password path="password"/></p>
		    		
		<p><form:label path="passwordConfirm">Confirm Password:
		<form:errors path="passwordConfirm"/></form:label>
		<form:password path="passwordConfirm"/></p>
		
		<p><input type="submit" value="Register"/></p>
		    
	    </form:form>
</body>
</html>