<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Fortran Dashboard | Lesson</title>
</head>
<body>
	<h1>Fortran!</h1>
	<h1><c:out value="${topic}"/></h1>
	<ul class="list-inline">
		<li><a href="/m/38/0553/0733">Set up</a></li>
		<li><a href="/m/38/0483/0345">Forms</a></li>
		<li><a href="/m/38/0553/0342">Cards</a></li>
		<li><a href="/m/26/0553/0348">Advanced</a></li>
		<li><a href="/m/26/0568/0143">Binary</a></li>
	</ul>
	<div id="comments">
		<p><c:out value="${content}"/></p>
	</div>
</body>
</html>