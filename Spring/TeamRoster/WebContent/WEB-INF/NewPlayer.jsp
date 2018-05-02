<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Player</title>
</head>
<body>
	<p>Add a new player to your team</p>
		<form method = "POST" action="/TeamRoster/teams?id=<% request.getParameter("id"); %>">
	<p>First Name: <input type="text" name="first_name"></p>
	<p>Last Name: <input type="text" name="last_name"></p>
	<p>Age: <input type="text" name="age"></p>
	<button>Add</button>
	</form>
</body>
</html>