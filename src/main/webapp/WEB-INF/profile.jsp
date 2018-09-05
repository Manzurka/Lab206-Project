<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <link rel="stylesheet" href="/css/style.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            <script src="/js/script.js"></script>
            <script> 	
                //for profile page: displays user's posts and hides comments
                $(document).ready(function(){
                    $('#posts').show();
                    $('#comments').hide();
                //toggle between comments and posts
                    $("#toggle").click(function() {
                        if ($('#posts').is(':hidden')) {
                            $('#comments').hide();
                            $('#posts').show();
                            $("#toggle").html("See recent comments");
                        }
                        else if ($('#comments').is(':hidden')) {
                            $('#posts').hide();
                            $('#comments').show();
                            $("#toggle").html("See recent posts");
                        }
                    });
                });
            </script>
            <title>Teccy Space | <c:out value="${user.firstName} ${user.lastName}"/></title>
    </head>
    <body>
        <%@ include file = "snippets/header.jsp" %>

        <!-- Body -->
        <div class="container">
            <div class="row mb-3">
                <div class="align-center col-sm-7">
                    <div class="row">
                        <div class="col-sm-2">
                            <!-- User profile image, show default if there is no image in the database -->
                            <c:choose>
                                <c:when test="${user.file.getId() != null}">
                                    <a href="/profile/${user.id}">
                                        <img class="avatar2" src="/imageDisplay?id=${user.id}" alt="User Avatar"/>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/profile/${user.id}">
                                        <img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar2">
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-sm-10">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">First Name: ${user.firstName}</li>
                                <li class="list-group-item">Last Name: ${user.lastName}</li>
                            </ul>
                        </div>
                    </div>
                    <div class="row" id="bio2">
                        <div class="col-sm-12">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Points: ${user.points}</li>
                                <li class="list-group-item">Cohort: ${user.cohort}</li>
                                <li class="list-group-item">GitHub: <a target = "_blank" href="${user.github}">${user.github}</a></li>
                                <li class="list-group-item">About me: ${user.about}</li> 
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="card bg-light mb-3" style="max-width: 30rem;">
                        <div class="card-header">Badge</div>
                        <div class="card-body">
                            <c:forEach var="badge" items="${user.badges}">
                                <img class="badge-img" src="/badgeImage?id=${badge.id}">
                            </c:forEach>
                            <h5 class="card-title"></h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">
                <div class="card bg-white mb-3" style="max-width: auto; max-height: auto;">
                    <div class="card-header bg-white">Projects:
                        <c:if test="${user.projects.size() < 3}">
                            <c:if test="${user.id == currentUser.id}">
                                <button type="button" class="btn bg-cosmic-cobalt text-white my-2 my-sm-0 float-right" data-toggle="modal" data-target="#projectsModal" aria-label="editProjects">
                                    Add Project
                                </button>
                            </c:if>
                        </c:if>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <c:forEach items="${user.projects}" var="project">
                                <div class="col-sm-3 content-panel2">
                                    <h5 class="card-title"></h5>
                                    <img class="avatar3" src="/projectImage?id=${project.id}" alt="Project Img"/>
                                    <p class="card-text">${project.about}</p>
                                    <c:if test="${user.id == currentUser.id}">
                                        <a href="" class="shoe-project text-gray-blue" data-toggle="modal" data-project-id="<c:out value="${project.id}"/>"><i class="fa fa-edit" aria-hidden="true"></i></a>
                                        <a href="/project/${project.id}/delete" class="shoe-project text-gray-blue"><i class="fa fa-trash" aria-hidden="true"></i></a>
                                    </c:if>
                                </div>
                            </c:forEach>    
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">
                <button type="button" class="btn btn-secondary" id="toggle">See recent comments</button>
            </div>
            <hr>
            <div id="posts" class="row">
                    <div class="col-sm-12">  
                    <h3>Recent Posts:</h3>   
                    <c:forEach items="${user.post}" var="post">   
                        
                            <a href="/post/<c:out value="${post.id}"/>/show">
                                <h4 class="mb-1">${post.title}</h4>
                            </a>
                            Uploaded Files:
                            <c:forEach var="file" items="${post.attachments}">
                                (<a href='/showFile/<c:out value="${file.id}"/>' target="_blank"><c:out value="${file.fileName}"/></a>)
                            </c:forEach>
                            <p>${show}</p>
                            <i class="fa fa-tags"></i>
                            <ul class="list-inline">
                                <c:forEach var="tag" items="${post.tags}">
                                    <li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>">${tag.subject}</span></li>
                                </c:forEach>
                            </ul>
                            <p class="mb-1">${post.content}</p>
                            <small class="text-muted">Posted on: <fmt:formatDate type = "date" value ="${post.createdAt}"></fmt:formatDate></small>
                        
                    </c:forEach>  
                </div>     
            </div>
            <div id="comments" class="row">
                <div class="col-sm-12">  
                    <h3>Recent Comments:</h3>
                    <c:forEach items="${user.comments}" var="comment">
                        <div class="col-sm-12">
                            <div class="list-group">
                                Commented on post: 
                                <a href="/post/<c:out value="${comment.post.id}"/>/show" class="list-group-item list-group-item-action flex-column align-items-start">
                                    <h4 class="mb-1">${comment.post.title}</h4>
                                </a>
                                <small class="text-muted"> on <fmt:formatDate type = "date" value ="${comment.createdAt}"></fmt:formatDate></small>
                                <p class="mb-1">${comment.content}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <!-- Project Modal -->
        <div id="projectsModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content" id="projectEdit23" >
                    <form action="/project/create" method="post" enctype="multipart/form-data" id="projEdit">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="modal-header">                      
                            <h2 class="modal-title">Add Project</h2>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Thumbnail</span>
                                </div>
                                <div class="custom-file">
                                    <input name="thumbnail" type="file" class="custom-file-input" id="inputGroupFile01">
                                    <label class="custom-file-label" for="inputGroupFile01">Choose file for Project</label>
                                </div>
                            </div>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">About this Project</span>
                                </div>
                                <textarea id="about" name="about" class="form-control" placeholder="About Project"></textarea>
                            </div>
                            <button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
                        </div>
                    </form>
                </div>
            </div>
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
