<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search | Top Songs</title>
</head>
<body>
	<p>Top Ten Songs:</p>
	<a href="/dashboard">Dashboard</a>
		<c:forEach var="song" items="${results}">
			<p><c:out value="${results.indexOf(song)+1}"/></p>
			<p><a href="/songs/<c:out value="${song.getId()}"/>"><c:out value="${song.getName()}"/></a> - <a href="/search/?artist=<c:out value="${song.getArtist()}"/>"><c:out value="${song.getArtist()}"/></a></p>
			<p><c:out value="${song.getRating()}"/>/10</p>
		</c:forEach>
</body>
</html>

