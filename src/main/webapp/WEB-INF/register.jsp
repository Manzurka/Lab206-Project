<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#register">Register</button>
		
		<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		    <div class="modal-dialog modal-dialog-centered">
		        <div class="modal-content">
		            <div class="modal-header">
		              <h5 class="modal-title" id="exampleModalLongTitle">Register</h5>
		              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		                <span aria-hidden="true">&times;</span>
		              </button>
		            </div>
		            <div class="modal-body">
		             
					<p><form:errors path="user.*"/></p>
		
						<div class="reg">
		
		                    <form:form method="POST" action="/registration" modelAttribute="user">
					        <div class="row">
			                    <div class="col-md-6">
									<form:label path="firstName">First Name:</form:label>
									<form:input path="firstName"/>
									<p>
										<form:errors path="firstName" style="color:red;" />
									</p>
					       		</div>
			                </div>
			                <div class="row">
			                    <div class="col-md-6">
									<form:label path="lastName">Last Name:</form:label>
									<form:input path="lastName"/>
									<p>
										<form:errors path="lastName" style="color:red;" />
									</p>
					       		</div>
			                </div>
							<div class="row">
				             	<div class="col-md-6">
						            <form:label path="email">Email:</form:label>
						            <form:input path="email"/>
						       	</div>
					        </div>
				        	<p><form:errors path="email" /></p>
		
					       	<div class="row">
			             		<div class="col-md-6">
						            <form:label path="password">Password:</form:label>
						            <form:password path="password"/>
					       		</div>
			           		</div>
					        <p><form:errors path="password" /></p>
					        <div class="row">
			             		<div class="col-md-6">
						            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
						            <form:password path="passwordConfirmation"/>
					        	</div>
			           		</div>
				            <p><form:errors path="passwordConfirmation"/></p>
				        	<input type="submit" value="Register" class="btn btn-success"/>
			    		</form:form>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
	</body>
</html>