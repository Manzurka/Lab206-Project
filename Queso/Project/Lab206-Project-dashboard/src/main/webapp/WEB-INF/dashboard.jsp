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
						<button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
					</div>
				</div>
			</form>
			<a href="#"><i class="fa fa-cog fa-2x nav-link"></i></a>
		</nav>
			<div class="row">
				<div class="col-md-6 offset-md-1">
					
					<button class="btn btn-info float-right" id="newPost">New Post</button>
					<h1>Recent Posts</h1>
					<div id="feed">
						<div class="row">
							<div class="col-12">
							
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 offset-md-2">
					<div class="row">
						<div class="col-12">
							<h1>Leaderboard</h1>
							<ol>
								<li>Person</li>
								<li>Person</li>
								<li>Person</li>
								<li>Person</li>
								<li>Person</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<h1>Quicklinks</h1>
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
	</body>
</html>