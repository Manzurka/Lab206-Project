<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team</title>
</head>
<body>
	<p><c:out value="${team.getTeamName()}"/></p>
	<a href="add_player">New<c:out value="${team.getTeamName()}"/></a>
	<table>
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Action</th>
		</thead>
			<c:if test = "${team.getTeamSize()!=0}">
				<c:forEach var="i" begin="0" end="${team.getTeamSize()-1}">
					<tr>
						<td><c:out value="${team.getPlayer(i).getFirstName()}"/></td>
						<td><c:out value="${team.getPlayer(i).getLastName()}"/></td>
						<td><c:out value="${team.getPlayer(i).getAge()}"/></td>
						<td><a href='DeletePlayer?playerId=${i}'>Delete</a></td>
					</tr>
				</c:forEach>
			</c:if>
	</table>
</body>
</html>