<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<p>Songs by artist:<c:out value="${artist}"/></p>
		<c:choose>
			<c:when test="${!found}">
				<p>No artist with that name, try again!</p>
			</c:when>
				<c:otherwise>
					<table>
						<thead>
							<th>Title</th>
							<th>rating</th>
							<th>actions</th>
						</thead>
						<tbody>
							<c:forEach var="song" items="${results}">
								<tr>
									<td><a href="/songs/<c:out value="${song.getId()}"/>"><c:out value="${song.getName()}"/></a></td>
									<td><c:out value="${song.getRating()}"/></td>
									<td><a href="songs/delete/<c:out value="${song.getId()}"/>">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
		</c:choose>
</body>
</html>


