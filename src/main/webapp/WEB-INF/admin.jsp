<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LAB_206 | Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
		body {
			margin-left: 30px;
			margin-right: 30px;
		}
		nav {
			padding: 15px;
			background-color: #FFC656;
		}
		button, .sub {
			background-color: #2E328E;
			color: white;
		}
		.modal-header {
			background-color: #FFC656;
		}
		.dash {
			background-color: #8D99AE;
			color: white;
		}
		table, tr, td, th {
			padding: 10px;
		}
	</style>
</head>
<body>
	<nav>
	<h1>Lab 206</h1><span>Admin</span>
	</nav>
	
	<br>
	
<button type="button" class="btn announce" data-toggle="modal" data-target="#announcement">Create Announcement</button>

<!-- Modal -->
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
        
		<form action="" method="post">
			<label for="subject">Subject: </label>
			<br>
			<input type="text" name="subject"/>
			
			<br>
			<br>
			
			<label for="description">Announcement: </label>
			<br>
			<textarea rows="4" cols="50" name="description"/></textarea>

      </div>
      <div class="modal-footer">
        <input type="submit" class="btn sub" />
      </div>
      
      </form>
      
    </div>
  </div>
</div>

	<br>
	<br>
	
<button type="button" class="btn announce" data-toggle="modal" data-target="#student">Invite Student</button>

<!-- Modal -->
<div class="modal fade" id="student" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Register New Student</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
		<form action="" method="post">
			<label for="firstName">First Name: </label>
			<br>
			<input type="text" name="firstName"/>
			
			<br>
			
			<label for="lastName">Last Name: </label>
			<br>
			<input type="text" name="lastName"/>
			
			<br>
			
			<label for="email">Email: </label>
			<br>
			<input type="text" name="email"/>

      </div>
      <div class="modal-footer">
        <input type="submit" class="btn sub" value="Send Email"/>
      </div>
      
      </form>
      
    </div>
  </div>
</div>

	<br>
	<br>

	
<button type="button" class="btn" data-toggle="modal" data-target="#remove">Remove Student</button>

<!-- Modal -->
<div class="modal fade" id="remove" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Remove Student</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        
        <table>
        
        <tr>
			<th>First</th>
			<th>Last</th>
			<th>Email</th>
			<th>Points</th>
			<th>Action</th>
		</tr>
        
		<c:forEach var="user" items="${ all_users }" >
		<tr>
			<td><c:out value="${user.firstName}"/></td>
			<td><c:out value="${user.lastName}"/></td>
			<td><c:out value="${user.email}"/></td>
			<td><c:out value="${user.points}"/></td>
			<td><a href="/user/${ user.id }/delete">Delete</a></td>
		</tr>
		</c:forEach>
		
		</table>
        
        
      </div>
    </div>
  </div>
</div>
	
	<br>
	<br>
	
	
	<a href="/dashboard" class="btn dash">To Dashboard</a>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>