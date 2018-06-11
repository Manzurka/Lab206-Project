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

	</head>
	<body>
		<!-- Nav bar -->
		<nav class="navbar sticky-top shadow-small" id="navvy">
			<img src="/img/logo.png" alt="Lab 206 Logo" id="logo">
			<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">Name: <c:out value="${currentUser.firstName} ${currentUser.lastName}"/></li>
				<li class="nav-item">Points: <c:out value="${currentUser.points}"/></li>
			</ul>
			<!-- Search bar -->
			<form class="my-2 my-lg-0" id="searchy">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search query..." aria-label="Search query">
					<div class="input-group-append">
						<button class="btn bg-cosmic-cobalt text-white my-2 my-sm-0" type="submit">Search</button>
					</div>
				</div>
			</form>
			<!-- Settings button -->
			<button type="button" class="close" data-toggle="modal" data-target="#settingsModal" aria-label="Settings">
				<i class="fa fa-cog nav-link"></i>
			</button>
		</nav>
		<div class="row" id="headerRow">
			<!-- Recent posts header -->
			<div class="col-md-6 offset-md-1 rounded-top bg-gunmetal">
				<button class="btn bg-blue-jean text-ghost-white float-right" id="newPost" data-toggle="modal" data-target="#newPostModal">New Post</button>
				<h1 class="text-ghost-white">Recent Posts</h1>
			</div>
			<!-- Announcements header -->
			<div class="col-md-3 offset-md-1 rounded-top bg-gunmetal">
				<h1 class="text-ghost-white">Announcements</h1>
			</div>
		</div>
		<div class="row" id="contentRow">
			<div class="col-md-6 offset-md-1">
				<div class="row" id="feed">
					<!-- Iterate through posts to fill recent posts -->
					<c:forEach var="post" items="${posts}"> 
						<div class="col-12 content-panel">
							<div class="row">
								<div class="col-sm-2">
									<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
								</div>
								<div class="col-sm-6">
									<h4><c:out value="${post.title}"/></h4>
									Uploaded File: <a href="#">file.js</a>
								</div>
								<div class="col-sm-3">
									<i class="fa fa-tags"></i>
									<ul class="list-inline">
										<!-- Iterate through tags in each post -->
										<c:forEach var="tag" items="${post.tags}">
											<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>"><c:out value="${tag.subject}"/></span></li>
										</c:forEach>
									</ul>
								</div>
								<div class="col-sm-1">
									<a href="#" class="like text-gunmetal"><i class="fa fa-thumbs-up float-right"></i></a>
								</div>
							</div>
							<div class="row">
								<div class="container">
									<div class="col-12">
										<p><c:out value="${post.content}"/></p>
									</div>
									<div class="col-12">
										<!-- Total comments and show -->
										<p><c:out value="${post.comments.size()}"/> Comments | <a href="#">Show Comments <i class="fa fa-angle-double-down"></i></a></p>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-3 offset-md-1">
				<div class="row">
					<!-- Announcements go here-->
					<div class="col-12 content-panel">
						<p>Announcements go here</p>
					</div>
				</div>
				<div class="row">
					<!-- Leaderboard header -->
					<div class="col-12 rounded-top text-ghost-white bg-gunmetal">
						<h1>Leaderboard</h1>
					</div>
					<!-- Leaderboard content -->
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
					<!-- Quicklink header -->
					<div class="col-12 rounded-top text-ghost-white bg-gunmetal">
						<h1>Quicklinks</h1>
					</div>
					<!-- Quicklinks list; iterate through quicklinks -->
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
		
		<!-- Modal for new post -->
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
						<form:form action="/post/create" modelAttribute="newPost" method="post">
						<div class="row mb-3">
							<div class="col-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text" id="courseRelated">Course Related</span>
									</div>
									<label class="switch">
										<input type="checkbox" id="course" name="course" aria-describedby="courseRelated">
										<span class="slider round"></span>
									</label>
								</div>
							</div>
							<div class="col-6">
								
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text" id="newPostLanguage">Language</span>
									</div>
									<select class="form-control" id="language" name="language" aria-label="Language" aria-describedby="newPostLanguage">
										<option>C++</option>
										<option>C#</option>
										<option>CSS</option>
										<option>HTML</option>
										<option>Java</option>
										<option>JavaScript</option>
										<option>Perl</option>
										<option>PHP</option>
										<option>Python</option>
										<option>Ruby</option>
									</select>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="newPost-title">Title</span>
							</div>
							<form:input path="title" class="form-control" aria-label="Title" aria-describedby="newPost-title"/>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Tags</span>
							</div>
							<input type="text" class="form-control" id="tag1" name="tag1">
							<input type="text" class="form-control" id="tag2" name="tag2">
							<input type="text" class="form-control" id="tag3" name="tag3">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Content</span>
							</div>
							<form:textarea path="content" class="form-control" aria-label="Content"/>
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
						<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
						</form:form>
			    	</div>
				</div>
			</div>
		</div>
		
		<!-- Modal for settings-->
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
		
		<!-- Modal for comments -->
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
		
		<!-- Scripts -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		<!-- Auto-opens new post modal if user was creating post and had errors -->
		<c:if test="${posting == true}">
			<script type="text/javascript">
			    $(document).ready(function(){
			        $('#newPostModal').modal('show');
			    });
			</script>
		</c:if>
		
	</body>
</html>