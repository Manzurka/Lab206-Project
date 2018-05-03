<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Team</title>
</head>
<body>
	<p>Create a new team</p>
	<form action = "/TeamRoster/NewTeam" method="POST">
		<p>Team Name: <input type="text" name="team_name"></p>
		<button>Create</button>
	</form>
</body>
</html>