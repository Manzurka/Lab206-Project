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
		<nav class="navbar" id="navvy">
			<img src="/img/logo.png" alt="Lab 206 Logo" id="logo">
			<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">Name: Mr. Test</li>
				<li class="nav-item">Points: 5000</li>
			</ul>
			<form class="my-2 my-lg-0" id="searchy">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search query..." aria-label="Search query">
					<div class="input-group-append">
						<button class="btn bg-cosmic-cobalt text-white my-2 my-sm-0" type="submit">Search</button>
					</div>
				</div>
			</form>
			<a href="#"><i class="fa fa-cog fa-2x text-gray-blue"></i></a>
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
							<div class="col-sm-4">
								<i class="fa fa-tags"></i>
								<ul class="list-inline">
									<li class="list-inline-item">python</li>
									<li class="list-inline-item">django</li>
									<li class="list-inline-item">login/reg</li>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="container">
								<div class="col-12">
									<p>This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. 
										This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. </p>
									<a href="#" class="view-post">View Post&nbsp;<i class="fa fa-angle-double-down"></i></a>
								</div>
								<div class="col-12">
									<p><a href="#">12 Comments</a> | <a href="#">Show Comments</a></p>
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
							<div class="col-sm-4">
								<i class="fa fa-tags"></i>
								<ul class="list-inline">
									<li class="list-inline-item">java</li>
									<li class="list-inline-item">jstl</li>
									<li class="list-inline-item">templating</li>
								</ul>
							</div>
						</div>
						<div class="row">
							<div class="container">
								<div class="col-12">
									<p>This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. 
										This is content that is comfortably contextual. This is content that is comfortably contextual. This is content that is comfortably contextual. </p>
									<a href="#" class="view-post">View Post&nbsp;<i class="fa fa-angle-double-down"></i></a>
								</div>
								<div class="col-12">
									<p><a href="#">2 Comments</a> | <a href="#">Show Comments</a></p>
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
	</body>
</html>