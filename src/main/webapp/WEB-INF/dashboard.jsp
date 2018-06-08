<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
			YAY 
			<a href="/fileUploadPage">Add Image</a>
			<p>${currentUser.firstName}</p>
			<c:choose>
			<c:when test="${currentUser.image != null}">
			 	<img alt="product image" src="/avatars/${currentUser.image}" width="100px">
			</c:when>
			<c:otherwise>
				<img alt="product image" src="/avatars/peccy.png" width="100px">
			</c:otherwise>
			</c:choose>
			<p>${fileName}  ${msg}</p>
	</body>
</html>