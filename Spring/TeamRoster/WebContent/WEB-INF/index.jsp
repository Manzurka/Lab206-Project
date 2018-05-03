<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roster</title>
</head>
<body>
	<h1>Prototype Roster</h1>
	<a href="teams">New Team</a>
	<table>
		<thead>
			<th>Team</th>
			<th>Players</th>
			<th>Action</th>
		</thead>
		<c:if test = "${roster.getRosterSize()!=0}">
			<c:forEach var="i" begin="0" end = "${roster.getRosterSize()-1}">
			<tr>
				<td><c:out value="${roster.getTeam(i).getTeamName()}"/></td>
				<td><c:out value="${roster.getTeam(i).getTeamName()}"/></td>
				<td><a href='teams?id=<c:out value="${i}"/>'>Details</a> <a href='DeleteTeam?id=<c:out value="${i}"/>'>Delete<</a></td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>
