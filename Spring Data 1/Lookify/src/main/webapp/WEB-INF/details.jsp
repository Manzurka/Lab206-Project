<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Details</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
		<p>Title: <c:out value="${song.getName()}"/></p>
		<p>Artist: <a href="/search/?artist=<c:out value="${song.getArtist()}"/>"><c:out value="${song.getArtist()}"/></a></p>
		<p>Rating (1-10): <c:out value="${song.getRating()}"/></p>
	<a href="/songs/delete/<c:out value="${song.getId()}"/>">Delete</a>
</body>
</html>