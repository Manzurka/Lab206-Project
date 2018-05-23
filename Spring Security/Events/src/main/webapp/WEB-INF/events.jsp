<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Events</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="submit" value="Logout" />
	</form>
	
	<h1>Welcome, <c:out value="${currentUser.firstName}"/></h1>
	
	<h2>Here are some events in your state:</h2>
		<table>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Actions/Status</th>
			</tr>
			<tbody>
				<c:forEach var="event" items="${inStateEvents}">
					<tr>
						<td><a href="/events/<c:out value="${event.id}"/>"><c:out value="${event.name}"/></a></td>
						<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.eventDate}"/></td>
						<td><c:out value="${event.location}"/></td>
						<td><c:out value="${event.host.getFirstName()}"/></td>
						<td><c:if test="${event.host == currentUser}">
								<a href="/events/<c:out value="${event.id}"/>/edit">Edit</a>   
								<a href="/events/<c:out value="${event.id}"/>/delete">Delete</a>
							 </c:if>
							 <c:if test="${!event.guests.contains(currentUser) && event.host != currentUser }">
							 	<a href="/events/<c:out value="${event.id}"/>/addguest/<c:out value="${currentUser.id}"/>">Join</a>
							 </c:if>
							 <c:if test ="${event.guests.contains(currentUser) && event.host != currentUser }">
							 	Joining  
							 	<a href="/cancel/<c:out value="${currentUser.id}"/>/<c:out value="${event.id}"/>">Cancel</a>
							 </c:if></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

	<h2>Here are some of the events in other states:</h2>
		<table>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>State</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
			<tbody>
				<c:forEach var="event" items="${outOfStateEvents}">
					<tr>
						<td><a href="/events/<c:out value="${event.id}"/>"><c:out value="${event.name}"/></a></td>
						<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.eventDate}"/></td>
						<td><c:out value="${event.location}"/></td>
						<td><c:out value="${event.state}"/></td>
						<td><c:out value="${event.host.getFirstName()}"/></td>
						<td><c:if test="${event.host == currentUser}">
								<a href="/events/<c:out value="${event.id}"/>/edit">Edit</a>   
								<a href="/events/<c:out value="${event.id}"/>/delete">Delete</a>
							 </c:if>
							 <c:if test="${!event.guests.contains(currentUser) && event.host != currentUser }">
							 	<a href="/events/<c:out value="${event.id}"/>/addguest/<c:out value="${currentUser.id}"/>">Join</a>
							 </c:if>
							 <c:if test ="${event.guests.contains(currentUser) && event.host != currentUser }">
							 	Joining  
							 	<a href="/cancel/<c:out value="${currentUser.id}"/>/<c:out value="${event.id}"/>">Cancel</a>
							 </c:if></td>
					</tr>
				    </c:forEach>
			 	</tbody>
		 	</table>
		
	<h2>Create an Event</h2>
			
		<p><form:errors path="event.*"/></p>
	    <form:form method="POST" action="/addEvent" modelAttribute="event">
	    
		<p><form:label path="name">Name:</form:label>
		<form:input path="name"/></p>
		
		<p><form:label path="eventDate">Date:</form:label>
		<form:input type="date" path="eventDate"/></p>
		
		<p><form:label path="location">Location:</form:label>
		<form:input path="location"/>
			<form:select path ="state">
		    <c:forEach var="state" items="${listOfstates}">
		    <form:option path ="state" value="${state}"/>
		    </c:forEach>
		    </form:select></p>
				
		 <input type="submit" value="Create"/>
		 
	     </form:form>
</body>
</html>