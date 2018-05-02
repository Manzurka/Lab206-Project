<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mcajayon.teamroster.models.Team" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roster</title>
</head>
<body>
	<h1>Prototype Roster</h1>
	<a href="/TeamRoster/NewTeam">New Team</a>
	<table>
		<tr>
			<th>Team</th>
			<th>Players</th>
			<th>Action</th>
		</tr>
	<% for (int i=0; i<Team.getTeams().size(); i++) { %>
		<tr>
			<td><%= Team.getTeams().get(i).getTeamName() %></td>
			<td><%= Team.getTeams().get(i).getPlayers().size() %></td>
			<td><a href="/TeamRoster/Teams?id=<%=i%>">Details</a></td>
			<td><a href="/TeamRoster/Teams?id=<%=i%>&delete=true">Delete</a></td>
		</tr>
	<% } %>	
	</table>
</body>
</html>
