<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lookify! | Dashboard</title>
</head>
<body>
	<a href="/songs/new">Add New</a><a href="/songs/topSongs">Top Songs</a>
	<form action="/search">
		<input type="submit" value="Search">
		<input type="text" placeholder="Search artists" name="artist">
	</form>
	<table>
		<tr>
			<th>Name</th>
			<th>rating</th>
			<th>actions</th>
		</tr>
		<c:forEach items="${songs}" var="song">
		<tr>
			<td><a href="/songs/<c:out value="${song.getId()}"/>"><c:out value="${song.getName()}"/></a></td>
			<td><c:out value="${song.getRating()}"/></td>
			<td><a href="/songs/delete/<c:out value="${song.getId()}"/>">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>