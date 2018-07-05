<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab 206 | Moderator</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<style>
	a:hover {
	color: #FFC656;
	}
	.feedbackTable, .reportTable {
		height: 500px;
    	overflow-y: auto;
	}
	thead {
		background-color: #FFC656;
	}
	
	td a:hover {
		color: #2E328E;
	}
</style>
</head>
<body>

	<a href="/dashboard" class="btn"><i class="fas fa-home"></i> Dashboard</a>

	<div class="col-md-7 feedbackTable">

	<h1>Associate Feedback</h1>

	<table class="table">
	<thead>
	<tr>
		<th scope="col">Content</th>
		<th scope="col">Rating</th>
		<th scope="col">By</th>
		<th scope="col">Reviewed</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="feedback" items="${ all_feedback }" >
	
	<tr>
		<td><a href="/feedback/${ feedback.id }" title="View Feedback"><c:out value="${feedback.content}"/></a></td>
		<td><c:out value="${feedback.rating}"/></td>
		<td><a href="" title="View Profile"><c:out value="${feedback.feedbackCreator.firstName} ${feedback.feedbackCreator.lastName}"/></a></td>
		<td><c:out value="${feedback.reviewed}"/></td>
	</tr>
	
	</c:forEach>
	
	
	</tbody>
	</table>
	</div>

	<br>
	
	<div class="col-md-7 reportTable">

	<h1>Associate Reports</h1>

	<table class="table">
	<thead>
	<tr>
		<th scope="col">Content</th>
		<th scope="col">Rating</th>
		<th scope="col">Reporter</th>
		<th scope="col">Reported</th>
		<th scope="col">Reviewed</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="report" items="${ all_reports }" >
	
	<tr>
		<td><a href="/report/${ report.id }" title="View Report"><c:out value="${report.content}"/></a></td>
		<td><c:out value="${report.rating}"/></td>
		<td><a href="" title="View Profile"><c:out value=""/></a></td>
		<td><c:out value=""/></td>
		<td><c:out value="${report.reviewed}"/></td>
	</tr>
	
	</c:forEach>
	
	
	</tbody>
	</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>