<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teccy Space | Recent Announcements</title>
	<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
		
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="/js/script.js"></script>
		
		
		<c:if test="${editing == true}">
			<script type="text/javascript">
			    $(document).ready(function(){
			        $('#settingsModal').modal('show');
			    });
			</script>
		</c:if>
		
</head>
<body>


	 <!-- Nav bar -->
		<nav class="navbar sticky-top shadow-small" id="navvy">
		<div class="dropdown">
			<button class="close" type="button" data-toggle="dropdown">
			<i class="fa fa-bars" aria-hidden="true"></i></button>
			<ul class="dropdown-menu test">
            <!-- Settings button -->
			    <li><a href="#settingsModal" data-toggle="modal" data-target="#settingsModal" aria-label="Settings">
					<i class="fa fa-cog nav-link" aria-hidden="true"></i>Settings</a>
				</li>
            <!-- Help button -->
			    <li><a href="#helpModal" data-toggle="modal" data-target="#helpModal" aria-label="Help">
					<i class="fa fa-question-circle nav-link" aria-hidden="true"></i>Help</a>
				</li>
            <!-- Feedback button -->
				<li><a href="#feedbackModal" data-toggle="modal" data-target="#feedbackModal" aria-label="Feedback">
					<i class="fa fa-comment nav-link" aria-hidden="true"></i>Feedback</a>
				</li>
				<li>
            <!-- Logout button -->
					<form id="logoutForm" method="POST" action="/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<button type="submit" class="text-button"><i class="fa fa-power-off nav-link" aria-hidden="true"></i>Logout</button>
					</form>
				</li>
			</ul>
		</div>			
			
		<a href="/dashboard"><img src="/img/logo.png" alt="Lab 206 Logo" id="logo"></a>
        	<!-- User profile image, show default if there is no image in the database -->
			<c:choose>
				<c:when test="${currentUser.file.getId() != null}">
					<a href="/profile/${currentUser.id}">
						<img class="avatar" src="/imageDisplay?id=${currentUser.id}" alt="User Avatar"/>
					</a>
				</c:when>
				<c:otherwise>
		        	<a href="/profile/${currentUser.id}">
		                <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
		            </a>
				</c:otherwise>
            </c:choose>

			<ul class="navbar-nav mr-auto">
				<li class="nav-item">Name: <c:out value="${currentUser.firstName} ${currentUser.lastName}"/></li>
				<li class="nav-item">Points: <c:out value="${currentUser.points}"/></li>
			</ul>
			
			<!-- Search bar -->
			<form class="my-2 my-lg-0" id="searchy" action="/search">
				<div class="input-group">
					<input name="keyword" type="text" class="form-control" placeholder="Search query..." aria-label="Search query"/>
					<select name="category">
						<option>Posts</option>
						<option>Comments</option>
						<option>Users</option>
						<option>Tags</option>
					</select>
					<div class="input-group-append">
						<button class="btn bg-cosmic-cobalt text-white my-2 my-sm-0" type="submit">Search</button>
					</div>
				</div>
			</form>
		</nav>
		
		
		
		<!--Search Results-->
		<!--for comments-->
		<c:forEach var="comment" items="${comments}">
				<div class="col-12 content-panel">
					<div class="row">
							<div class="container">
								<div class="col-12">
									<p><c:out value="${comment.content}"/></p>
									<p>commented <a href="/profile/${comment.commenter.id}">${comment.commenter.firstName}</a> to the post: <a href=#>${comment.post.title}</a></p>
								</div>
							</div>
					</div>		
				</div>
		</c:forEach>
		<!--for users-->
		<c:forEach var="user" items="${searchedusers}">
				<div class="col-12 content-panel">
					<div class="row">
						<div class="col-12">
							<div class="col-sm-6">
								<p><a href="/profile/${user.id}">${user.firstName} ${user.lastName}</a></p>
							</div>
							<div class="col-sm-2">
							<!-- User profile image, show default if there is no image in the database -->
								<c:choose>
										<c:when test="${user.file.getId() != null}">
											<a href="/profile/${user.id}">
											<img class="avatar" src="/imageDisplay?id=${user.id}" alt="User Avatar"/>
											</a>
										</c:when>
										<c:otherwise>
										<a href="/profile/${user.id}">
											<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
										</a>
										</c:otherwise>
								</c:choose>
							</div>
						</div>			
					</div>
				</div>
		</c:forEach>
		<!--for tags-->
		<c:if test="${tags != null}">
			<c:forEach var="post" items="${tags}">
					<div class="col-12 content-panel">
							<div class="row">
								<div class="col-12">
									<h4><a href=#>${post.title}</a></h4>
									<a href="#" class="like text-gray-blue"><i class="fa fa-thumbs-up float-right"></i></a>
										<ul class="list-inline">
												<i class="fa fa-tags"></i>
											<!-- Iterate through tags in each post -->
											<c:forEach var="tag" items="${post.tags}">
												<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>"><c:out value="${tag.subject}"/></span></li>
											</c:forEach>
										</ul>
									<p>Uploaded Files:
										<c:forEach var="file" items="${post.attachments}">
											<a target="_blank" href='/showFile/<c:out value="${file.id}"/>'><c:out value="${file.fileName}"/></a>  
										</c:forEach>
									</ul>
								<p>Uploaded Files:
									<c:forEach var="file" items="${post.attachments}">
										<a target="_blank" href='/showFile/<c:out value="${file.id}"/>'><c:out value="${file.fileName}"/></a>  
									</c:forEach>
								</p>
								<p>${post.content}</p>
								<p><i>created by <a href="/profile/${post.author.id}"></a>${post.author.firstName}</a> on <fmt:formatDate type = "date" 
									value ="${post.createdAt}"></fmt:formatDate></i></p>
								<p>
									<c:out value="${post.comments.size()}"/> Comments | 
									<a href="" class="show-post" data-toggle="modal" data-post-id='<c:out value="${post.id}"/>'>View Comments <i class="fa fa-angle-double-down"></i></a>
									<a href="" data-toggle="modal" data-target="#reportModal" class="report text-gray-blue float-right"><i class="fa fa-flag" aria-hidden="true"></i></a>
								</p>
							</div>
						</div>
					</div>
			</c:forEach>
		</c:if>
		
		
	
		<br/>
		
		<a href='/' style="margin-left: 30px;"><i class="fas fa-chevron-left"></i> Back To Dashboard</a>
		
		<br/>
		<br/>
	
	<div class="col-md-10 announcementTable">
	
		<br/>
	
		<h2>Recent Announcements <i class="fas fa-bullhorn"></i></h2>	
		
		<table class="table">
		<thead>
		<tr>
			<th>Subject</th>
			<th>Description</th>
			<th>Created At</th>
		</tr>
		</thead>
		
		<c:forEach var="announcement" items="${ announcements }" >
		
		<tr>
			<td><c:out value="${announcement.subject}"/></td>
			<td><c:out value="${announcement.content}"/></td>
			<td><fmt:formatDate value="${announcement.createdAt}" pattern="M-dd-yyyy / h:mm a z" /></td>
		</tr>
		
		</c:forEach>
		
		</table>
	</div>
	
	
	
	
	<!-- Settings Modal -->
		<div id="settingsModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">Settings</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form:form action="/user/edit" modelAttribute="user" method="post" enctype="multipart/form-data">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Avatar</span>
								</div>
								<div class="custom-file">
									<input type="file" name="avatar" class="custom-file-input" id="inputGroupFile01">
									<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
								</div>
							</div>
							<form:errors path="firstName"/>
							<form:errors path="lastName"/>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Name</span>
								</div>
								<input type="text" name="firstName" class="form-control" value="<c:out value="${currentUser.firstName}"/>">
								<input type="text" name="lastName" class="form-control" value="<c:out value="${currentUser.lastName}"/>">
							</div>
							<form:errors path="email"/>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">Email</span>
								</div>
								<input type="text" class="form-control" name="email" aria-label="Email" aria-describedby="basic-addon1" value="<c:out value="${currentUser.email}"/>">
							</div>
							<form:errors path="about"/>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">About Me<br>(Optional)</span>
								</div>
								<textarea name="about" placeholder='<c:out value="${currentUser.about}"/>'  class="form-control" aria-label="AboutMe"><c:out value="${currentUser.about}"/></textarea>
							</div>
							<form:errors path="passwordConfirmation"/>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Password Confirmation</span>
								</div>
								<input type="password" name="passwordConfirmation" class="form-control" aria-label="PC"/>
							</div>
							<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
						</form:form>
			    	</div>
				</div>
			</div>
		</div>
	
	
	
	
	<!-- Help Modal -->
		<div id="helpModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">Help</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<h3>FAQ: Rules and Etiquette</h3>
						<ul>
							<li>Please be professional and respectful of others.</li>
							<li>Do not overuse the dislike button.</li>
							<li>Do not share exam codes. Plagiarism is not tolerated on this platform and will be reported.</li>
							<li>Do not share ANY Amazon related information and internal links.</li>
							<li>If you have any suggestion(s) or if something is not working, please submit your feedback on the top left menu and click on the <i class="fa fa-comment text-gunmetal" aria-hidden="true"></i>.</a></li>
							<li>If you would like to file a report, please click the <i class="fa fa-flag text-gunmetal" aria-hidden="true"></i> on a post located on the bottom right.</li>
						</ul>
						</div>
			    	</div>
				</div>
			</div>
			
		<!-- Report Modal -->
		<div id="reportModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">File a Report</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
							</div>
							<p>If this post or comment(s) related have abusive or unprofessional content, please submit your report. We will review the content and remove anything that does not follow our platform's Rules and Etiquette found on the help page.</p>
							<textarea class="form-control" aria-label="Content"></textarea>
						</div>
						
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
			    	</div>
				</div>
			</div>
		</div>
		
		<!-- Feedback Modal -->
		<div id="feedbackModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">Submit feedback</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
							</div>
							<p>Please provide feedback on how we can improve Teccy Space or if something is not working.</p>
							
						<form:form method="POST" action="/create/feedback" modelAttribute="feedb">	
							
							<form:textarea path="content" class="form-control" aria-label="Content"></form:textarea>
							
							<br>
							
							<form:label path="rating">Rate Feedback:
							<form:input 
								path="rating"
								type="range"
						        class="custom-range"
						        name="weight"
						        id="range_weight"
						        value="5"
						        min="1"
						        max="10"
						        oninput="range_weight_disp.value = range_weight.value"
							/>
							<output id="range_weight_disp"></output>
							
							</form:label>
							
							</div>
							
							
							<input type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right" value="Submit"/>
						
						</form:form>
			    	</div>
				</div>
			</div>
		</div>
	
	
	</body>
</html>