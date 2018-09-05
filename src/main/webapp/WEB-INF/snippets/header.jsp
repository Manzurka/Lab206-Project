<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Nav bar -->
<nav class="navbar sticky-top shadow-small mb-3" id="navvy">
    <div class="dropdown">
        <button class="close" type="button" data-toggle="dropdown">
        <i class="fa fa-bars" aria-hidden="true"></i></button>
        <ul class="dropdown-menu test">
        
        <!-- Mod Dash Link -->
        <c:if test="${ currentUser.roles[0].name == 'ROLE_MOD' }">
            <li><a href="/mod"><i class="fas fa-user-ninja nav-link"></i>Moderator</a></li>
        </c:if>
            
        <!-- Admin Dash Link -->
        <c:if test="${ currentUser.roles[0].name == 'ROLE_ADMIN' }">
            <li><a href="/admin"><i class="fas fa-user-shield nav-link"></i>Admin</a></li>
            <li><a href="/mod"><i class="fas fa-user-ninja nav-link"></i>Moderator</a></li>
        </c:if>
            
        <!-- Feedback button -->
        <li><a href="#feedbackModal" data-toggle="modal" data-target="#f" aria-label="Feedback">
            <i class="fa fa-comment nav-link" aria-hidden="true"></i>Feedback</a>
        </li>
        <!-- Settings button -->
            <li><a href="#settingsModal" data-toggle="modal" data-target="#settingsModal" aria-label="Settings">
                <i class="fa fa-cog nav-link" aria-hidden="true"></i>Settings</a>
            </li>
        <!-- Help button -->
            <li><a href="#helpModal" data-toggle="modal" data-target="#helpModal" aria-label="Help">
                <i class="fa fa-question-circle nav-link" aria-hidden="true"></i>Help</a>
            </li>
        
            <li>
        <!-- Logout button -->
                <form id="logoutForm" method="POST" action="/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="text-button"><i class="fa fa-power-off nav-link" aria-hidden="true"></i>Logout</button>
                </form>
            </li>
        </ul>
    </div>		
        
    <a href="/dashboard"><img src="/img/logo.png" alt="Lab 206 Logo" id="logo"></a>
    <!-- User profile image, show default if there is no image in the database -->
    <c:choose>
        <c:when test="${currentUser.file.getId() != null}">
            <a href="/profile/${currentUser.id}">
                <img class="avatar" src="/imageDisplay?id=${currentUser.id}" alt="User Avatar"/>
            </a>
        </c:when>
        <c:otherwise>
            <a href="/profile/${currentUser.id}">
                <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
            </a>
        </c:otherwise>
    </c:choose>

    <ul class="navbar-nav mr-auto">
        <li class="nav-item">Name: <c:out value="${currentUser.firstName} ${currentUser.lastName}"/></li>
        <li class="nav-item">Points: <c:out value="${currentUser.points}"/></li>
        <li class="nav-item">
            <c:forEach var="badge" items="${currentUser.badges}" begin="0" end="4">
                <img class="badge-img-sm" src="/badgeImage?id=${badge.id}">
            </c:forEach>
        </li>
    </ul>
    
    <!-- Search bar -->
    <form class="my-2 my-lg-0" id="searchy" action="/search">
        <div class="input-group">
            <input name="keyword" type="text" class="form-control" placeholder="Search query..." aria-label="Search query"/>
            <select name="category">
                <option>Posts</option>
                <option>Comments</option>
                <option>Users</option>
                <option>Tags</option>
                <option>Badges</option>
            </select>
            <div class="input-group-append">
                <button class="btn bg-cosmic-cobalt text-white my-2 my-sm-0" type="submit">Search</button>
            </div>
        </div>
    </form>
</nav>