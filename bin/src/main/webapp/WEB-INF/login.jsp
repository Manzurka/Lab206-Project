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
		            <form method="POST" action="/login">
		            
		                <div class="form-group">
		                    <label for="username">Email address:</label>
		                    <input type="email" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Enter email" name="username" width=500px>
		                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		                </div>
		                <div class="form-group">
		                    <label for="password">Password:</label>
		                    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
		                </div>
		                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                    <button type="submit" class="btn bg-cosmic-cobalt text-ghost-white">Login</button>
		            </form>
		        </div>
		        <div class="col-3"></div>
		    </div>
		</div>        
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>