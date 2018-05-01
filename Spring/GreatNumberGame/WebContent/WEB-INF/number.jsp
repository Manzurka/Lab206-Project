<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Great Number Game</title>
</head>
<body>

	<h1>Welcome to the Great Number Game!</h1>
	<p>I am thinking of a number between 1 and 100</p>
	<p>Take a guess!</p>

		<c:if test="${ guess == x }">
		<p><c:out value="${ x }"/> was the number!</p>
		
		<form action="Games" method="POST">
			<input type="hidden" name="restart" value="true">
			<input type="submit" value="Play again!">
		</form>
		</c:if>
		
		<c:if test="${ guess < x }">
		<p>Too low!</p>
		</c:if>
		
		<c:if test="${ guess > x }">
		<p>Too high!</p>
		</c:if>
		
		<form action="Games" method="POST">
		<input type="number" name="guess">
		<input type="submit" value="Submit">
		</form>
		
</body>
</html>