<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Announcements, leaderboards, quicklinks -->
<div class="col-md-3">
    <div class="row">
        <div class="col-md-12 rounded-top bg-gunmetal">
            <h1 class="text-ghost-white collapsible" data-target-div="announcements">Announcements</h1>
        </div>
    </div>
    <div class="row">
        <!-- Announcements go here-->
        <div class="col-12 content-panel" id="announcements">
            <c:forEach var="announcement" items="${announcements}" varStatus="status"> 
                    <c:if test="${status.count <= 3}">
                        <h5>${announcement.subject}</h5>
                        <p>${announcement.content}</p>
                        <hr>
                    </c:if>
            </c:forEach>
            <a href="/announcements">View all</a>
        </div>
    </div>
    <div class="row mt-1">
        <!-- Leaderboard header -->
        <div class="col-12 rounded-top text-ghost-white bg-gunmetal">
            <h1 class="collapsible" data-target-div="leaderboard">Leaderboard</h1>
        </div>
    </div>
    <div class="row">
        <!-- Leaderboard content -->
        <div class="col-12 content-panel" id="leaderboard">
            <c:forEach var="user" items="${users}" varStatus="status">
                <c:if test="${status.count <= 5}">
                    <ol>
                        <div class="row mb-2 leader">
                            <c:if test="${status.index == 0}"><span class="badge bg-gold text-ghost-white"></c:if>
                            <c:if test="${status.index == 1}"><span class="badge bg-silver text-ghost-white"></c:if>
                            <c:if test="${status.index == 2}"><span class="badge bg-bronze text-ghost-white"></c:if>
                            <c:if test="${status.index == 3}"><span class="badge bg-onyx text-ghost-white"></c:if>
                            <c:if test="${status.index == 4}"><span class="badge bg-platinum text-ghost-white"></c:if>
                            ${status.index + 1}</span>
                            <c:choose>
                                <c:when test="${user.file.getId() != null}">
                                    <a href="/profile/${user.id}">
                                        <img class="avatar float-left" src="/imageDisplay?id=${user.id}" width=100px alt="User Avatar"/>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/profile/${post.author.id}">
                                        <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">Name: <c:out value="${user.firstName} ${user.lastName}"/></li>
                                <li class="nav-item">Points: <c:out value="${user.points}"/></li>
                                <li class="nav-item">
                                    <c:forEach var="badge" items="${user.badges}" begin="0" end="4">
                                        <img class="badge-img-sm" src="/badgeImage?id=${badge.id}">
                                    </c:forEach>
                                </li>
                            </ul>
                        </div>
                    </ol>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="row mt-1">
        <!-- Quicklink header -->
        <div class="col-12 rounded-top text-ghost-white bg-gunmetal">
            <div class="dropdown show">
                <a class="text-gray-blue float-right" href="#" role="button" data-toggle="dropdown">
                    <i class="fas fa-filter float-right post-header"></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <c:forEach var="language" items="${languages}">
                        <a class="dropdown-item quicklinkDropdown" href="" data-language="${language}">${language}</a>
                    </c:forEach>
                </div>
            </div>
            <span class="float-right">&nbsp;&nbsp;</span>
            <a href="" class="text-gray-blue" data-toggle="modal" data-target="#quicklinkModal"><i class="fas fa-plus float-right post-header"></i></a>
            <h1 class="collapsible" data-target-div="quicklinks">Quicklinks</h1>
        </div>
    </div>
    <div class="row">
        <!-- Quicklinks list; iterate through quicklinks -->
        <div class="col-12 content-panel" id="quicklinks">
            <ul id="quicklinkList">
                <c:forEach var="quicklink" items="${quicklinks}" varStatus="status">
                    <c:if test="${status.count <= 10}">
                        <li><a target="_blank" href="${quicklink.url}">${quicklink.name}</a>
                            <c:forEach var="tag" items="${quicklink.tags}">
                                <span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/> post-footer"><c:out value="${tag.subject}"/></span>
                            </c:forEach>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>