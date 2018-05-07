<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ninja Gold Game</title>
</head>
<body>
	<h1>Your Gold: <c:out value="${result}"/></h1>
	<div id="options">
		<div class="boxes">
			<h2>Farm</h2>
			<p>(earns 10-20 gold)</p>
			<form action="/process_gold" method="post">
				<input type="hidden" name="box" value="farm"/>
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="boxes">
			<h2>Cave</h2>
			<p>(earns 5-10 gold)</p>
			<form action="/process_gold" method="post">
				<input type="hidden" name="box" value="cave"/>
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="boxes">
			<h2>House</h2>
			<p>(earns 2-5 gold)</p>
			<form action="/process_gold" method="post">
				<input type="hidden" name="box" value="house"/>
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="boxes">
			<h2>Casino!</h2>
			<p>(earns/takes 0-50 gold)</p>
			<form action="/process_gold" method="post">
				<input type="hidden" name="box" value="casino"/>
				<input type="submit" value="Find Gold!">
			</form>
		</div>
	</div>
		<div id="activites">
		<h1>Activities:</h1>
			<div class="activitiesbox">
				<c:forEach var="activity" items="${activities}">
					<p> class="<c:out value="${activity.color}"/>"> <c:out value="${activity.message}"/></p>
				</c:forEach>
			</div>
		</div>
</body>
</html>