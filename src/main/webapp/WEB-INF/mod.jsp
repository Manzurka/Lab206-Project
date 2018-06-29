<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab 206 | Moderator</title>
<link rel="stylesheet" href="/css/moderator.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous"></head>
<body>

	<a href="/dashboard" class="btn"><i class="fas fa-home"></i> Dashboard</a>
	
	<br>
	
	<c:if test="${ currentUser.roles[0].name == 'ROLE_ADMIN' }">
	   <a href="/admin" class="btn"><i class="fas fa-user-shield"></i> Admin Dashboard</a>
	 </c:if>

	<div class="col-md-7 feedbackTable">

	<h1><i class="far fa-lightbulb"></i> Associate Feedback</h1>

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
		<td><a href="" class="c_feedback" data-target="#showFeed" data-toggle="modal" data-feed-id="<c:out value="${feedback.id}"/>" title="View Feedback"><c:out value="${feedback.content}"/></a></td>
		<td><c:out value="${feedback.rating}"/></td>
		<td><a href="profile/${feedback.feedbackCreator.id}" title="View Profile" target="_blank"><c:out value="${feedback.feedbackCreator.firstName} ${feedback.feedbackCreator.lastName}"/></a></td>
		<td><c:out value="${feedback.reviewed}"/></td>
	</tr>
	
	</c:forEach>
	
	
	</tbody>
	</table>
	</div>
	
	<!-- Feedback Modal -->

<div class="modal fade" id="showFeed" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Feedback</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            
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
	
	<tr>
		<td><p id="feedContent"></p></td>
		<td><p id="feedRating"></p></td>
		<td><p id="feedSubmitter"></p></td>
		<td><p id="feedReviewed"></p></td>
	</tr>
	
	
	</tbody>
	</table>

      </div>
      <div class="modal-footer">
      
      <form:form action="/reviewed" method="post" modelAttribute="review">
      
      	<form:input type="hidden" path="reviewed" value="true"/>
        <input type="submit" class="btn reviewed" value="Mark as Reviewed"/>
        
      </form:form>
        
      </div>
      
      
    </div>
  </div>
</div>

	<br>
	
	<div class="col-md-7 reportTable">

	<h1><i class="far fa-flag"></i> Associate Reports</h1>

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

	<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script src="/js/moderator.js"></script>

</body>
</html>