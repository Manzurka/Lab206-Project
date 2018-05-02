<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mcajayon.teamroster.models.Team" %>
<%@ page import="com.mcajayon.teamroster.models.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team</title>
</head>
<body>
	<% Team team = Team.getTeams().get(Integer.parseInt(request.getParameter("id"))); %>
	<p><%=team.getTeamName()%>
	<a href="/TeamRoster/addPlayer?id<%=request.getParameter("id")%>">New Player</a>
	
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Actions</th>
		</tr>
		<% for(int i=0; i<team.getPlayers().size(); i++) { %>
		<tr>
			<td><%=team.getPlayers().get(i).getFirstName() %></td>
			<td><%=team.getPlayers().get(i).getLastName() %></td>
			<td><%=team.getPlayers().get(i).getAge() %></td>
			<td><a href="/TeamRoster/addPlayer?team_id=<%=request.getParameter("id")%>&player_id=<%=i%>&delete=true">Delete</a></td>
		<% } %>
	</table>
</body>
</html>