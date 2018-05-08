<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Secret Code</title>
</head>
<body>
	<p>What is the code?</p>
	<p><span class="red"><c:out value="${error}"/></span></p>
	<form action="/" method="post">
		<input type="text" name="code">
		<input type="submit" value="Try code">
	</form>
</body>
</html>