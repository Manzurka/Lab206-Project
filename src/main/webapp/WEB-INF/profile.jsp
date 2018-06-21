<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>Profile Page</title>
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
		<button type="button" class="close" data-toggle="modal" data-target="#settingsModal" aria-label="Settings">
			<i class="fa fa-cog fa nav-link"></i>
		</button>
	</nav>
	<div class="container">
		
	
	
	<div class="row">
		
			<div class="align-center col-sm-7">
				<div class="row">
					<div class="col-sm-2">	
						<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar2">
					</div>
					<div class="col-sm-10">
						<ul class="list-group list-group-flush">
					        <li class="list-group-item">First Name: </li>
					        <li class="list-group-item">Last Name: </li>
					        <li class="list-group-item"></li>
					        
					        
						</ul>
					</div>
				</div>
				<div class="row" id="bio2">
					<div class="col-sm-12">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Points: </li>
					        <li class="list-group-item">Cohort: </li>
					        <li class="list-group-item">GitHub: </li>
							<li class="list-group-item">About me: </li>	
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="card bg-light mb-3" style="max-width: 30rem;">
					  <div class="card-header">Patches</div>
					  <div class="card-body">
					    <h5 class="card-title"></h5>
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					  </div>
				</div>
				<div class="card bg-light mb-3" style="max-width: 30rem;">
					  <div class="card-header">Badges</div>
					  <div class="card-body">
					    <h5 class="card-title"></h5>
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					  </div>
				</div>
			</div>
		
	</div>
	<div class="col-sm-12">
			<div class="card bg-white mb-3" style="max-width: auto; max-height: auto;">
				  <div class="card-header bg-white">Projects
				  	<button type="button" class="btn bg-cosmic-cobalt text-white my-2 my-sm-0 float-right" data-toggle="modal" data-target="#projectsModal" aria-label="editProjects">
						Edit Projects
					</button>
					</div>
					  <div class="card-body">
					  	<div class="row">
					  		<div class="col-sm-4">
							    <h5 class="card-title"></h5>
								    <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar2">
								    <p class="card-text">Project 1 info and Thumbnails.</p>
							</div>
							<div class="col-sm-4">
							    <h5 class="card-title"></h5>
								    <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar2">
								    <p class="card-text">Project 2 info and Thumbnails.</p>
							</div>
							<div class="col-sm-4">
							    <h5 class="card-title"></h5>
								    <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar2">
								    <p class="card-text">Project 3 info and Thumbnails.</p>
							</div>
						</div>
					  </div>
				</div>
	<div class="row">
	<h2>Recent Posts</h2>
		<div class="col-sm-12">	
			<div class="list-group">
				<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				  <div class="d-flex w-100 justify-content-between">
				    <h5 class="mb-1">List group item heading</h5>
				    <small>3 days ago</small>
				  </div>
				  <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				  <small>Donec id elit non mi porta.</small>
				</a>
				<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				  <div class="d-flex w-100 justify-content-between">
				    <h5 class="mb-1">List group item heading</h5>
				    <small class="text-muted">3 days ago</small>
				  </div>
				  <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				  <small class="text-muted">Donec id elit non mi porta.</small>
				</a>
				<a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				  <div class="d-flex w-100 justify-content-between">
				    <h5 class="mb-1">List group item heading</h5>
				    <small class="text-muted">3 days ago</small>
				  </div>
				  <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				  <small class="text-muted">Donec id elit non mi porta.</small>
				</a>
			</div>
		</div>
	</div>
		<div class="row">
		<h2>Recent Comments:</h2>
			<div class="col-sm-12">
				<div class="list-group">
				  <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				    <div class="d-flex w-100 justify-content-between">
				      <h5 class="mb-1">List group item heading</h5>
				      <small>3 days ago</small>
				    </div>
				    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				    <small>Donec id elit non mi porta.</small>
				  </a>
				  <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				    <div class="d-flex w-100 justify-content-between">
				      <h5 class="mb-1">List group item heading</h5>
				      <small class="text-muted">3 days ago</small>
				    </div>
				    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				    <small class="text-muted">Donec id elit non mi porta.</small>
				  </a>
				  <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
				    <div class="d-flex w-100 justify-content-between">
				      <h5 class="mb-1">List group item heading</h5>
				      <small class="text-muted">3 days ago</small>
				    </div>
				    <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
				    <small class="text-muted">Donec id elit non mi porta.</small>
				  </a>
				</div>
			</div>
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
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">Edit Projects</h2>
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
								<input type="file" class="custom-file-input" id="inputGroupFile01">
								<label class="custom-file-label" for="inputGroupFile01">Choose file for Project 1</label>
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">About this Project</span>
							</div>
							<textarea class="form-control" placeholder="About Project 1"></textarea>
						
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Thumbnail</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="inputGroupFile01">
								<label class="custom-file-label" for="inputGroupFile01">Choose file for Project 2</label>
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">About this Project</span>
							</div>
							<textarea class="form-control" placeholder="About Project 2"></textarea>

						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">Thumbnail</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="inputGroupFile01">
								<label class="custom-file-label" for="inputGroupFile01">Choose file for Project 3</label>
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">About this Project</span>
							</div>
							<textarea class="form-control" placeholder="About Project 3"></textarea>
						
						</div>
</body>
</html>