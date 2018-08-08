<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="/js/script.js"></script>
		<title>Profile Page</title>
</head>
<body>
	<nav class="navbar mb-3" id="navvy">
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
						<img class="avatar" src="/imageDisplay?id=${currentUser.id}" width=100px alt="User Avatar"/>
					  </a>
				 </c:when>
				 <c:otherwise>
		            <a href="/profile/${currentUser.id}">
		                <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
		            </a>
	     		</c:otherwise>
            </c:choose>
		<ul class="navbar-nav mr-auto">
				<li class="nav-item">Name: ${currentUser.firstName} ${currentUser.lastName}</li>
				<li class="nav-item">Points: ${currentUser.points}</li>
			</ul>
		<form class="my-2 my-lg-0" id="searchy">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search query..." aria-label="Search query">
				<div class="input-group-append">
					<button class="btn bg-cosmic-cobalt text-white my-2 my-sm-0" type="submit">Search</button>
				</div>
			</div>
		</form>
		<button type="button" class="close" data-toggle="modal" data-target="#settingsModal" aria-label="Settings">
			<i class="fa fa-cog fa nav-link"></i>
		</button>
	</nav>
	<div class="container">
	<div class="row mb-3">
		
			<div class="align-center col-sm-7">
				<div class="row">
					<div class="col-sm-2">
					 <!-- User profile image, show default if there is no image in the database -->
			 <c:choose>
				 <c:when test="${user.file.getId() != null}">
					  <a href="/profile/${user.id}">
						<img class="avatar2" src="/imageDisplay?id=${user.id}" alt="User Avatar"/>
					  </a>
				 </c:when>
				 <c:otherwise>
		            <a href="/profile/${user.id}">
		                <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar2">
		            </a>
	     		</c:otherwise>
            </c:choose>
			</div>
					<div class="col-sm-10">
						<ul class="list-group list-group-flush">
					        <li class="list-group-item">First Name: ${user.firstName}</li>
					        <li class="list-group-item">Last Name: ${user.lastName}</li>
						</ul>
					</div>
				</div>
				<div class="row" id="bio2">
					<div class="col-sm-12">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Points: ${user.points}</li>
					        <li class="list-group-item">Cohort: </li>
					        <li class="list-group-item">GitHub: <a target = "_blank" href="${user.github}">${user.github}</a></li>
							<li class="list-group-item">About me: </li>	
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="card bg-light mb-3" style="max-width: 30rem;">
					  <div class="card-header">Badge</div>
					  <div class="card-body">
					    <h5 class="card-title"></h5>
					  </div>
				</div>
			</div>
		
	</div>
	<div class="col-sm-12">
			<div class="card bg-white mb-3" style="max-width: auto; max-height: auto;">
				  <div class="card-header bg-white">Projects:
				  
				  <c:if test="${user.projects.size() < 3}">
				  	<c:if test="${user.id == currentUser.id}">
					  	<button type="button" class="btn bg-cosmic-cobalt text-white my-2 my-sm-0 float-right" data-toggle="modal" data-target="#projectsModal" aria-label="editProjects">
							Add Project
						</button>
					</c:if>
				  </c:if>
					  <div class="card-body">
					  	<div class="container">
					  	<div class="row row-centered">
					  	<c:forEach items="${user.projects}" var="project">
					  		<div class="col-sm-3 content-panel2">
							    <h5 class="card-title"></h5>
								    <img class="avatar3" src="/projectImage?id=${project.id}" alt="Project Img"/>
								    <p class="card-text">${project.about}</p>
								    <c:if test="${user.id == currentUser.id}">
									   <a href="" class="shoe-project text-gray-blue" data-toggle="modal" data-project-id="<c:out value="${project.id}"/>"><i class="fa fa-edit" aria-hidden="true"></i></a>
									   <a href="/project/${project.id}/delete" class="shoe-project text-gray-blue"><i class="fa fa-trash" aria-hidden="true"></i></a>
									</c:if>
							</div>
						</c:forEach>	
						</div>
					  </div>
				</div>
	<div class="row">
	<h2>Recent Posts <- </h2>
	<h2>-> Recent Comments</h2>	
	<c:forEach items="${user.post}" var="post">
			<div class="col-sm-12">	
				<div class="list-group">					
					<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
					  <div class="d-flex w-100 justify-content-between">
					    <h5 class="mb-1">${post.title}</h5>
					    <small class="text-muted">${post.createdAt}</small>
					  </div>
					  <p class="mb-1">${post.content}</p>
					  <c:forEach var="tag" items="${post.tags}">
							<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>"><c:out value="${tag.subject}"/></span></li>
					  </c:forEach>
					</a>
				</div>
			</div>
	</c:forEach>
	</div>
		<div class="row">
		<h2>Recent Comments:</h2>
		<c:forEach items="${user.comments}" var="comment">
			<div class="col-sm-12">
				<div class="list-group">
				  <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				    <div class="d-flex w-100 justify-content-between">
				      
				      <small class="text-muted">${comment.createdAt}</small>
				    </div>
				    <p class="mb-1">${comment.content}</small>
				  </a>
				</div>
				
			</div>
			</c:forEach>
		</div>
	</div>
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
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Avatar</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="inputGroupFile01">
								<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Name</span>
							</div>
							<input type="text" class="form-control" placeholder="First name">
							<input type="text" class="form-control" placeholder="Last name">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">Email</span>
							</div>
							<input type="text" class="form-control" aria-label="Email" aria-describedby="basic-addon1">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Password</span>
							</div>
							<input type="password" class="form-control" aria-label="Password" aria-describedby="basic-addon1">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">GitHub</span>
							</div>
							<input type="text" class="form-control" aria-label="github" aria-describedby="basic-addon1">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">About Me</span>
							</div>
							<textarea class="form-control" aria-label="aboutme" aria-describedby="basic-addon1"></textarea>
						</div>
						
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
			    	</div>
				</div>
			</div>
		</div>
		<div id="projectsModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content" id="projectEdit23" >
					<form action="/project/create" method="post" enctype="multipart/form-data" id="projEdit">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div class="modal-header">						
							<h2 class="modal-title">Add Project</h2>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Thumbnail</span>
								</div>
								<div class="custom-file">
									<input name="thumbnail" type="file" class="custom-file-input" id="inputGroupFile01">
									<label class="custom-file-label" for="inputGroupFile01">Choose file for Project</label>
								</div>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">About this Project</span>
								</div>
								<textarea id="about" name="about" class="form-control" placeholder="Please limit your text to 4-255 characters."></textarea>
							</div>
							<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
						</div>
					</form>
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
							<textarea class="form-control" aria-label="Content"></textarea>
						</div>
						
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
			    	</div>
				</div>
			</div>
		</div>	
</body>
</html>