<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Checkerboard</title>
		<link rel="stylesheet" href="static/style.css">
	</head>
<body>

	<% Integer width = 0;
	Integer height = 0; %>
	
		<% if(request.getParameter("width") != null) { %>
		<% width = Integer.valueOf(request.getParameter("width")); %>
		<% } %>
		<% if(request.getParameter("height") != null) { %>
		<% height = Integer.valueOf(request.getParameter("height")); %>
		<% } %>
		
		<h1>Checkerboard: <%=width %>w X <%=height %>h</h1>
		
			<% for(int i = 0; i < height; i++) { %>
			
				<div class="checkerboard">
				<% for(int j = 0; j < width; j++) { %>
					<% if(i % 2 == 0) { %>
						<% if(j % 2 == 0) { %>
							<div class="blue"></div>
						<% } else { %> 
							<div class="darkorchid"></div>
						<% } %>
					<% } else { %>
						<% if(j % 2 == 0) { %>
							<div class="darkorchid"></div>
						<% } else { %> 
							<div class="blue"></div>
						<% } %>
					<% } %>
				<% } %>
				</div>	
			<% } %>
</body>
</html>
