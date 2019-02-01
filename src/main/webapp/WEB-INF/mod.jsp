<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab 206 | Moderator</title>
<link rel="stylesheet" href="/css/moderator.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous"></head>

<body onload="loaderDuration()" style="margin:0;">

	<div id="loader"></div>

	<div style="display:none;" id="block" class="anixmate-bottom">

	<div id="name">
		<h1>Welcome <b><c:out value="${currentUser.firstName}"></c:out></b></h1>
	</div>

	<a href="/dashboard" class="btn"><i class="fas fa-home"></i> Dashboard</a>
	
	<br>
	
	<!-- If the user also has the ADMIN role, this button will display to direct over to the Admin dashboard -->
	<c:if test="${ currentUser.roles[0].name == 'ROLE_ADMIN' }">
		<a href="/admin" class="btn"><i class="fas fa-user-shield"></i> Admin Dashboard</a>
		<br>
	</c:if>
	
	<br>

	<!-- Assign badge to user -->
		<!-- <div class="col-md-6">
			<h4>Assign Badge to User</h4>
			<form action="/badge/assign" method="POST">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<select name="badgeId" id="badges-list">
					<c:forEach var="badge" items="${all_badges}">
						<option value="${badge.id}">${badge.name}</option>
					</c:forEach>
				</select>
				<img src="/badgeImage?id=1" id="badge-preview" style="width:60px; height:60px">
				<select name="userId">
					<c:forEach var="u" items="${all_users}">
						<option value="${u.id}">${u.firstName} ${u.lastName}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn bg-cosmic-cobalt text-gray-blue">Assign Badge</button>
			</form>
		</div>
	</div> -->

	<!-- BADGE CREATION -->
		<div class="col-md-6 badgeCreate float-left">
		
		<div id="badgeRequests">
			<h2><i class="fas fa-bullhorn"></i> Create a New Badge</h2>
		</div>

		<form:form action="/new/badge" method="post" modelAttribute="badge" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">Name</span>
						</div>
						<input type="text" class="form-control" id="badgeName" name="name">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">Image</span>
						</div>
						<div class="custom-file">
							<input type="file" name="image" class="custom-file-input" id="currentInputGroupFile01">
							<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
						</div>
					</div>
				</div>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">Description</span>
				</div>
				<textarea name="description" id="badgeDescription" class="form-control" aria-label="description"></textarea>
			</div>
			<button type="submit" class="btn announce float-right">Upload</button>
			<!-- <div class="custom-file">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<label class="custom-file-label" for="image">Choose Image</label>
				<input id="image" type="file" name="image" class="custom-file-input"/>
				<form:input path="name"/>
				<input type='submit' value='Upload' class='btn'/>
			</div> -->
		</form:form>

		</div>

		<div class="col-md-6 badgeRequestTables float-right">
		
			<div id="badgeRequests">
				<h2><i class="fas fa-bullhorn"></i> Badge Requests</h2>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th>User</th>
						<th>Badge Name</th>
						<th>Badge Image</th>
						<th>Created At</th>
						<th>Review</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="request" items="${ badgeRequests }" >
						<tr>
							<td>${request.requester.firstName} ${request.requester.lastName}</td>
							<td>${request.requestedBadge.name}</td>
							<td><img src="/badgeImage?id=${request.requestedBadge.id}" style="width:60px;height:60px"></td>
							<td><fmt:formatDate value="${request.createdAt}" pattern="MM-dd-yyyy hh:mm a" /></td>
							<td><a href='/badge/request/${request.id}/approve'>Approve</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	<br>
	<br>
	
	<div class="col-md-6 announceTable">
	
	<div id="announcements">
		<h2><i class="fas fa-bullhorn"></i> Recent Announcements</h2>
	</div>
	
	<div id='announceButton'>
		<button type="button" class="btn announce" data-toggle="modal" data-target="#announcement">Create Announcement</button>
	</div>
	

	<table class="table">
	<thead>
	<tr>
		<th>Subject</th>
		<th>Description</th>
		<th>Created At</th>
		<th>Action</th>
	</tr>
	</thead>
		
		
	<c:forEach var="announcement" items="${ all_announcements }" >
	
	<tr>
		<td><c:out value="${announcement.subject}"/></td>
		<td><c:out value="${announcement.content}"/></td>
		<td><fmt:formatDate value="${announcement.createdAt}" pattern="MM-dd-yyyy hh:mm a" /></td>
		<td><a href='/announcement/${announcement.id}/archive'>Archive</a></td>
	</tr>
	
	</c:forEach>
	
	
	</table>
	</div>

	<!-- FEEDBACK TABLE -->

	<div class="col-md-6 feedbackTable">

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
		<td><p id="feedReview"></p></td>
	</tr>
	
	
	</tbody>
	</table>

			</div>
			
			<div class="modal-footer">
							
				<a  id='reviewMark'>Mark as Reviewed</a>
				
			</div>
			
		</div>
	</div>
</div>

	<br>
	
	<!-- REPORTS TABLE -->
	
	<div class="col-md-6 reportTable">

	<h1><i class="far fa-flag"></i> Associate Reports</h1>

	<table class="table">
	<thead>
	<tr>
		<th scope="col">Content</th>
		<th scope="col">User Reported</th>
		<th scope="col">Reported By</th>
		<th scope="col">Reviewed</th>
		<th scope="col">View Post</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="report" items="${ all_reports }" >
	
	<tr>
		<td><a href="" class='c_report' data-target="#showReport" data-toggle="modal" data-report-id="<c:out value="${report.id}"/>" title="View Report"><c:out value="${report.content}"/></a></td>
		<td><a href="profile/${report.reported.id}" title="View Profile" target='_blank'><c:out value="${report.reported.firstName} ${report.reported.lastName}"/></a></td>
		<td><c:out value="${report.reporter.firstName} ${report.reporter.lastName}"/></td>
		<td><c:out value="${report.reviewed}"/></td>
		<td><c:out value="${thePost}"></c:out></td>
	</tr>
	
	</c:forEach>
	
	
	</tbody>
	</table>
	</div>
	
	

<!-- Report Modal -->
<div class="modal fade" id="showReport" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Report</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
						
	<table class="table">
	<thead>
	<tr>
		<th scope="col">Content</th>
		<th scope="col">User Reported</th>
		<th scope="col">Reported By</th>
		<th scope="col">Reviewed</th>
	</tr>
	</thead>
	<tbody>
	
	<tr>
		<td><p id="reportContent"></p></td>
		<td><p id="userReported"></p></td>
		<td><p id="reporter"></p></td>
		<td><p id="reportReview"></p></td>
	</tr>
	
	
	</tbody>
	</table>

			</div>
			<div class="modal-footer">
			
				<a id='reportMarkedAsReviewed' class="btn reviewedButton">Mark as Reviewed</a>
				
			</div>
			
			
		</div>
	</div>
</div>	
	
	
<!-- Announcement Modal -->
<div class="modal fade" id="announcement" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">New Announcement</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
						
				
		<form:form method="POST" action="/mod/announce" modelAttribute="announce">
			<p>
							<form:label path="subject">Subject:</form:label>
							<form:input path="subject"/>
					</p>
					<p>
							<form:label path="content">Description:</form:label>
							<form:textarea path="content"/>
					</p>

			</div>
			<div class="modal-footer">
				<input type="submit" class="btn sub" />
			</div>
			
			</form:form>
			
		</div>
	</div>
</div>

	
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<!-- Located within the static folder -->
	<script src="/js/moderator.js"></script>
	<script src="/js/notify.js"></script>

</body>
</html>