<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Teccy Space | View Post</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="/js/script.js"></script>
		
		
		<!-- Auto-opens new post modal if user was creating post and had errors -->
		<c:if test="${editing == true}">
			<script type="text/javascript">
			    $(document).ready(function(){
			        $('#settingsModal').modal('show');
			    });
			</script>
		</c:if>

	</head>
	<body>
		<%@ include file = "snippets/header.jsp" %>

		<div class="row" id="contentRow">
			<!-- Show badge -->
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-10 offset-md-1 rounded-top bg-gunmetal">
                        <c:choose>
                            <c:when test="${currentUser.badges.contains(badge)}">
                                <p class="text-ghost-white float-right post-header">You already have this badge</p>
                            </c:when>
                            <c:when test="${request != null}">
                                <p class="text-ghost-white float-right post-header">Badge already requested</p>
                            </c:when>
                            <c:otherwise>
                                <form action="/badge/request" method="POST">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="hidden" name="badgeId" value='<c:out value="${badge.id}"/>'>
                                    <button type="submit" class="btn float-right post-header bg-cosmic-cobalt text-ghost-white">Request</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                        <img src='/badgeImage?id=<c:out value="${badge.id}"/>' class="badge-img float-left">
						<h1 class="text-ghost-white">&nbsp;<c:out value="${badge.name}"/></h1>
					</div>
				</div>
				<div class="row">
                    <div class="col-md-10 offset-md-1 rounded-top content-panel">
                        <p>Description: <c:out value="${badge.description}"/></p>
                        <table align="center">
                            <thead>
                                <tr>
                                    <th>Avatar</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Points</th>
                                    <th># of Badges</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${badge.users}">
                                    <tr>
                                        <td><a href="/profile/${user.id}"><img src='/imageDisplay?id=${user.id}' class="avatar"></a></td>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.points}</td>
                                        <td>${user.badges.size()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
				</div>
			</div>
			<!-- Announcements, leaderboards, quicklinks -->
			<%@ include file = "snippets/sidebar.jsp" %>
		</div>

		<!-- Settings Modal -->
		<%@ include file = "snippets/settings.jsp" %>
		
		<!-- Help Modal -->
		<%@ include file = "snippets/help.jsp" %>

		<!-- Feedback Modal -->
		<%@ include file = "snippets/feedback.jsp" %>
			
		<!-- Report Modal -->
		<%@ include file = "snippets/report.jsp" %>
		
	</body>
</html>
