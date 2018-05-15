<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
			<form:form action="/question/create" method="post" modelAttribute="q">
				
			<p><form:label path="question">Question:
			<form:errors path="question"/>
			<form:textarea path="question"></form:textarea>
			</form:label></p>
			
			<p><label for="tags">Tags:
				<input type="text" name="tagA">
				<input type="text" name="tagB">
				<input type="text" name="tagC"></label></p>
				
			<p><input type="submit" value="Submit"></p>
			
			</form:form>
</body>
</html>