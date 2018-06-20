<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
	    <title>Login</title>
	</head>
	<body id="login-body">
		<div class="container">
		    <div class="row">
		        <div class="col text-center">
		            <img src="/img/logo.png" alt="Lab 206 Logo">
		            <img src="/img/peccy.png" alt="Peccy" class="peccy">
		        </div>    
		    </div>
		    <div class="row">
		        <div class="col text-center">
		            <c:if test="${errorMessage != null}">
		                <c:out value="${errorMessage}"></c:out>
		            </c:if>
		        </div>
		    </div>
		    <div class="row">
		        <div class="col-3"></div>
		        <div class="col-6">
		        	<div class="card">
		        		<div class="card-header">
		        			<h2>Register</h2>
		        		</div>
		        		<div class="card-body">
				            <form:form method="POST" action="/user/create" modelAttribute="newUser">
				            	<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">Name</span>
									</div>
									<form:input path="firstName" placeholder="First name" class="form-control" aria-label="Content"/>
									<form:input path="lastName" placeholder="Last name" class="form-control" aria-label="Content"/>
									
								</div>
								<div class="container">
									<div class="row mb-3">
										<div class="col-5 offset-1">
											<span class="text-danger"><form:errors path="firstName"/></span>
										</div>
										<div class="col-5 offset-1">
											<span class="text-danger"><form:errors path="lastName"/></span>
										</div>
									</div>
								</div>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">Email</span>
									</div>
									<form:input path="email" placeholder="Email address" class="form-control" aria-label="Content"/>
								</div>
								<div class="container">
									<div class="row mb-3">
										<div class="col-11 offset-1">
											<span class="text-danger"><form:errors path="email"/></span>
										</div>
									</div>
								</div>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">About Me<br>(Optional)</span>
									</div>
									<form:textarea path="about" placeholder="Something about you" class="form-control" aria-label="Content"/>
								</div>
								<div class="container">
									<div class="row mb-3">
										<div class="col-11 offset-1">
											<span class="text-danger"><form:errors path="about"/></span>
										</div>
									</div>
								</div>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">Password</span>
									</div>
									<form:input type="password" path="password" class="form-control" aria-label="Content"/>
								</div>
								<div class="container">
									<div class="row mb-3">
										<div class="col-11 offset-1">
											<span class="text-danger"><form:errors path="password"/></span>
										</div>
									</div>
								</div>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">Confirm Password</span>
									</div>
									<form:input type="password" path="passwordConfirmation" class="form-control" aria-label="Content"/>
								</div>
								<div class="container">
									<div class="row mb-3">
										<div class="col-11 offset-1">
											<span class="text-danger"><form:errors path="passwordConfirmation"/></span>
										</div>
									</div>
								</div>
								<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Register</button>
				            </form:form>
		            	</div>
		            </div>
		        </div>
		        <div class="col-3"></div>
		    </div>
		</div>        
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>