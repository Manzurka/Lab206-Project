<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Dash</title>
</head>
<body>
	<h1>Welcome to the Admin Dashboard <c:out value="${currentUser.firstName}"/></h1>
	
		<c:forEach var="error" items="${errors}" >
			<c:out value="${error}"/>
	    </c:forEach>
	    
	    <table>
	    	<thead>
	    		<th>Name</th>
	    		<th>Email</th>
	    		<th>Action</th>
	    	</thead>
	    	<tbody>
	    		<c:forEach var="user" items="${users}">
	    		<tr>
	    			<td><c:out value="${user.getFullName()}"/></td>
	    			<td><c:out value="${user.getUsername()}"/></td>
	    		<c:choose>
		    		<c:when test='${!user.getRoles().contains(admin)}'>
		    			<td><a href='/admin/user/delete/<c:out value="${user.getId()}"/>'>Delete</a> | <a href='/admin/user/makeAdmin/<c:out value="${user.getId()}"/>'>Make Admin</a></td>
		    		</c:when>
		    	<c:otherwise>
		    		<td>Admin</td>
		    	</c:otherwise>
	    		</c:choose>
	    		</tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
	    
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	    
</body>
</html>