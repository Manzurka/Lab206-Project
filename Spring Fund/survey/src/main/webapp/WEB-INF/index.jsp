<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dojo Survey Index</title>
</head>
<body>
	<form action="login" method="POST">
	<p>Your Name: <input type="text" name="name"></p>
	Dojo Location:
	<select name="location">
		<option value="AZA">Tempe, AZ</option>
		<option value="SJO">San Jose, Costa Rica</option>
		<option value="SEA">Seattle, WA</option>
	</select>
	Favorite Language:
	<select name="language">
		<option value="Java">Java</option>
		<option value="Django">Django</option>
		<option value="Python">Python</option>
	</select>
	Comments (optional):
		<textarea name="comment"</textarea>
		<input type="submit" value="submit"
	</form>
</body>
</html>