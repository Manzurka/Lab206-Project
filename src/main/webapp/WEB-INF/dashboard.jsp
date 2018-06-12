<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Teccy Space | Dashboard</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	<body>
		<c:if test="${logoutMessage != null}" >
			<c:out value="${logoutMessage}"></c:out>
		</c:if>
		<nav class="navbar" id="navvy">
		<div class="dropdown">
			  <button class="close" type="button" data-toggle="dropdown">
			  <i class="fa fa-bars" aria-hidden="true"></i></button>
			  	<ul class="dropdown-menu test">
			    	<li><a href="#settingsModal" data-toggle="modal" data-target="#settingsModal" aria-label="Settings">
						<i class="fa fa-cog nav-link" aria-hidden="true"></i>Settings</a>
					</li>
			      	<li><a href="#helpModal" data-toggle="modal" data-target="#helpModal" aria-label="Help">
						<i class="fa fa-question-circle nav-link" aria-hidden="true"></i>Help</a>
					</li>
					<li><a href="#feedbackModal" data-toggle="modal" data-target="#feedbackModal" aria-label="Feedback">
						<i class="fa fa-comment nav-link" aria-hidden="true"></i>Feedback</a>
					</li>
					<li>
						<form id="logoutForm" method="POST" action="/logout"<i class="fa fa-power-off nav-link" aria-hidden="true"</i>>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						    <input type="submit" value="Logout" />
						</form>
					</li>
			  	</ul>
			</div>
			<img src="/img/logo.png" alt="Lab 206 Logo" id="logo">
			<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">Name: <c:out value="${currentUser.firstName} ${currentUser.lastName}"/></li>
				<li class="nav-item">Points: <c:out value="${currentUser.points}"/></li>
			</ul>
			<form class="my-2 my-lg-0" id="searchy">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search query..." aria-label="Search query">
					<div class="input-group-append">
						<button class="btn bg-cosmic-cobalt text-white my-2 my-sm-0" type="submit">Search</button>
					</div>
				</div>
			</form>	
		</nav>
		<div class="row" id="headerRow">
			<div class="col-md-6 offset-md-1 rounded-top bg-gunmetal">
				<button class="btn bg-blue-jean text-ghost-white float-right" id="newPost" data-toggle="modal" data-target="#newPostModal">New Post</button>
				<h1 class="text-ghost-white">Recent Posts</h1>
			</div>
			<div class="col-md-3 offset-md-1 rounded-top bg-gunmetal">
				<h1 class="text-ghost-white">Announcements</h1>
			</div>
		</div>
		<div class="row" id="contentRow">
			<div class="col-md-6 offset-md-1">
				<div class="row" id="feed">
					<div class="col-12 content-panel">
						<div class="row">
							<div class="col-sm-2">
								<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
							</div>
							<div class="col-sm-6">
								<h4>Help with Django Login/Reg</h4>
								Uploaded File: <a href="#">file.js</a>
							</div>
							<div class="col-sm-3">
								<i class="fa fa-tags"></i>
								<ul class="list-inline">
									<li class="list-inline-item">python</li>
									<li class="list-inline-item">django</li>
									<li class="list-inline-item">login/reg</li>
								</ul>
							</div>
							<div class="col-sm-1">
								<a href="#" class="like text-gunmetal"><i class="fa fa-thumbs-up float-right"></i></a>
							</div>
						</div>
						<div class="row">
							<div class="container">
								<div class="col-12">
									<p>This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. 
										This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. </p>
								</div>
								<div class="col-12">
									<p><a href="" data-toggle="modal" data-target="#commentModal">12 comments</a> | <a href="" data-toggle="modal" data-target="#commentModal">Add Comment</a> <a href="" data-toggle="modal" data-target="#reportModal" class="report text-gunmetal float-right"><i class="fa fa-flag" aria-hidden="true"></i></a></p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12 content-panel">
						<div class="row">
							<div class="col-sm-2">
								<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
							</div>
							<div class="col-sm-6">
								<h4>JSTL Templating</h4>
								Uploaded File: <a href="#">index.jsp</a>
							</div>
							<div class="col-sm-3">
								<i class="fa fa-tags"></i>
								<ul class="list-inline">
									<li class="list-inline-item">java</li>
									<li class="list-inline-item">jstl</li>
									<li class="list-inline-item">templating</li>
								</ul>
							</div>
							<div class="col-sm-1">
								<a href="#" class="like text-gunmetal"><i class="fa fa-thumbs-up float-right"></i></a>
							</div>
						</div>
						<div class="row">
							<div class="container">
								<div class="col-12">
									<p>This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. 
										This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. </p>
								</div>
								<div class="col-12">
									<p><a href="" data-toggle="modal" data-target="#commentModal">2 comments</a> | <a href="" data-toggle="modal" data-target="#commentModal">Add Comment</a> <a href="" data-toggle="modal" data-target="#reportModal" class="report text-gunmetal float-right"><i class="fa fa-flag" aria-hidden="true"></i></a></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 offset-md-1">
				<div class="row">
					<div class="col-12 content-panel">
						
					</div>
				</div>
				<div class="row">
					<div class="col-12 rounded-top text-ghost-white bg-gunmetal">
						<h1>Leaderboard</h1>
					</div>
					<div class="col-12 content-panel">
						<ol>
							<li>Person | 5000 points</li>
							<li>Person | 3000 points</li>
							<li>Person | 2000 points</li>
							<li>Person | 1000 points</li>
							<li>Person | 500 points</li>
						</ol>
						
					</div>
				</div>
				<div class="row">
					<div class="col-12 rounded-top text-ghost-white bg-gunmetal">
						<h1>Quicklinks</h1>
					</div>
					<div class="col-12 content-panel">
						<ul>
							<li><a href="#">Link1</a></li>
							<li><a href="#">Link2</a></li>
							<li><a href="#">Link3</a></li>
							<li><a href="#">Link4</a></li>
							<li><a href="#">Link5</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="newPostModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">New Post</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">Title</span>
							</div>
							<input type="text" class="form-control" aria-label="Title" aria-describedby="basic-addon1">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Tags</span>
							</div>
							<input type="text" class="form-control">
							<input type="text" class="form-control">
							<input type="text" class="form-control">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Content</span>
							</div>
							<textarea class="form-control" aria-label="Content"></textarea>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">File</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="inputGroupFile01">
								<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
							</div>
						</div>
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
			    	</div>
				</div>
			</div>
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
						
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
			    	</div>
				</div>
			</div>
		</div>
		
		<!-- Comment Modal -->
		<div id="commentModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">Add Comment</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Comment</span>
							</div>
							<textarea class="form-control" aria-label="Content"></textarea>
						</div>
						
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
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
							<textarea class="form-control" aria-label="Content"></textarea>
						</div>
						
						<button type="button" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
			    	</div>
				</div>
			</div>
		</div>
	</body>
</html>