<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Random Word Generator</title>
</head>
<body>
	<p>You have generated a word <c:out value="${ count }"/> times.</p>
	<h2><c:out value="${ words }"/></h2>
		<form action="" method="POST">
			<input type="submit" name="word" value="Generate">
		</form>
		<p>The last time you generated a word was: <c:out value="${ timestamp }"/>
</body>
</html>