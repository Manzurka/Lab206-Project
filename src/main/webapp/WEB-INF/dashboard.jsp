<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Teccy Space | Dashboard</title>
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="/js/script.js"></script>
		
		
		<!-- Auto-opens new post modal if user was creating post and had errors -->
		<c:if test="${posting == true}">
			<script type="text/javascript">
			    $(document).ready(function(){
			        $('#newPostModal').modal('show');
			    });
			</script>
		</c:if>
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
			<!-- Show post -->
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-10 offset-md-1 rounded-top bg-gunmetal">
						<c:choose>
							<c:when test="${searchResults == true}">
								<h1 class="text-ghost-white">Results for 
									<c:if test="${posts != null}">posts</c:if>
									<c:if test="${searchedUsers != null}">users</c:if>
									<c:if test="${comments != null}">comments</c:if>
									<c:if test="${tags != null}">tags</c:if>
									<c:if test="${searchedBadges != null}">badges</c:if>
								</h1>
							</c:when>
							<c:otherwise>
								<button class="btn bg-blue-jean text-ghost-white float-right" id="newPost" data-toggle="modal" data-target="#newPostModal">New Post</button>
								<h1 class="text-ghost-white">Recent Posts</h1>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 offset-md-1">
						<div class="row" id="feed">					
							<!--Search Results-->
							<!--for comments-->
							<c:forEach var="comment" items="${comments}">
								<div class="col-12 content-panel">
									<div class="row">
										<div class="container">
											<div class="col-12">
												<p><c:out value="${comment.content}"/></p>
												<p>commented <a href="/profile/${comment.commenter.id}">${comment.commenter.firstName}</a> to the post: <a href=#>${comment.post.title}</a></p>
											</div>
										</div>
									</div>		
								</div>
							</c:forEach>
							<!--for users-->
							<c:forEach var="user" items="${searchedUsers}">
								<div class="col-12 content-panel">
									<div class="row">
										<div class="col-12">
											<div class="col-sm-6">
												<p><a href="/profile/${user.id}">${user.firstName} ${user.lastName}</a></p>
											</div>
											<div class="col-sm-2">
											<!-- User profile image, show default if there is no image in the database -->
												<c:choose>
														<c:when test="${user.file.getId() != null}">
															<a href="/profile/${user.id}">
															<img class="avatar" src="/imageDisplay?id=${user.id}" alt="User Avatar"/>
															</a>
														</c:when>
														<c:otherwise>
														<a href="/profile/${user.id}">
															<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
														</a>
														</c:otherwise>
												</c:choose>
											</div>
										</div>			
									</div>
								</div>
							</c:forEach>
							<!--for tags-->
							<c:if test="${tags != null}">
								<c:forEach var="post" items="${tags}">
									<div class="col-12 content-panel">
										<div class="row">
											<div class="col-12">
												<h4><a href=#>${post.title}</a></h4>
												<a href="#" class="like text-gray-blue"><i class="fa fa-thumbs-up float-right"></i></a>
												<ul class="list-inline">
													<i class="fa fa-tags"></i>
													<!-- Iterate through tags in each post -->
													<c:forEach var="tag" items="${post.tags}">
														<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>"><c:out value="${tag.subject}"/></span></li>
													</c:forEach>
												</ul>
												<p>Uploaded Files:
													<c:forEach var="file" items="${post.attachments}">
														<a target="_blank" href='/showFile/<c:out value="${file.id}"/>'><c:out value="${file.fileName}"/></a>  
													</c:forEach>
												</p>
												<p>${post.content}</p>
												<p><i>created by <a href="/profile/${post.author.id}"></a>${post.author.firstName}</a> on <fmt:formatDate type = "date" 
													value ="${post.createdAt}"></fmt:formatDate></i></p>
												<p>
													<c:out value="${post.comments.size()}"/> Comments
													<a href="" data-toggle="modal" data-target="#reportModal" class="report text-gray-blue float-right"><i class="fa fa-flag" aria-hidden="true"></i></a>
												</p>
											</div>
										</div>
									</div>
								</c:forEach>
								
							</c:if>
							<c:if test="${searchedBadges != null}">
								<div class="col-12 content-panel">
									<table>
										<tbody>
											<c:forEach var="badge" items="${searchedBadges}">
												<tr class="clickable-row" data-href="badge/${badge.id}">
													<td><img src="/badgeImage?id=${badge.id}" class="badge-img"></td>
													<td><c:out value="${badge.name}"/></td>
													<td><c:out value="${badge.description}"/></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</c:if>
							<c:choose>
								<c:when test="${ totalPages != null }">
									<c:forEach var="post" items="${posts.content}">
										<c:choose>
											<c:when test="${post.answer != null}">
												<div class="col-12 content-panel answered">
											</c:when>
											<c:otherwise>
												<div class="col-12 content-panel">
											</c:otherwise>
										</c:choose>
										<div class="row">
											<c:choose>
												<c:when test="${post.author.file.getId() != null}">
													<a href="/profile/${post.author.id}">
														<img class="avatar" src="/imageDisplay?id=${post.author.id}" width=100px alt="User Avatar"/>
													</a>
												</c:when>
												<c:otherwise>
													<a href="/profile/${post.author.id}">
														<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
													</a>
												</c:otherwise>
											</c:choose>
			
											<div class="col-sm-6">
												<h4><a href="/post/<c:out value="${post.id}"/>/show"><c:out value="${post.title}"/></a></h4>
												Uploaded Files:
												<c:forEach var="file" items="${post.attachments}">
													(<a href='/showFile/<c:out value="${file.id}"/>' target="_blank"><c:out value="${file.fileName}"/></a>)
												</c:forEach>
												<p>${show}</p>
											</div>
											<div class="col-sm-3">
												<i class="fa fa-tags"></i>
												<ul class="list-inline">
													<!-- Iterate through tags in each post -->
													<c:forEach var="tag" items="${post.tags}">
														<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>"><c:out value="${tag.subject}"/></span></li>
													</c:forEach>
												</ul>
											</div>
											<div class="col-sm-1">
												<a href="#" class="like text-gray-blue"><i class="fa fa-thumbs-up float-right"></i></a>
											</div>
										</div>
										<div class="row">
											<div class="container">
												<div class="col-12">
													<p class="line-breaks"><c:out value="${post.content}"/></p>
												</div>
												<div class="col-12">
													<!-- Total comments and show -->
													<p>
														<c:out value="${post.comments.size()}"/> Comments 
														<a href="" data-toggle="modal" data-target="#reportModal" data-report-id="<c:out value="${post.id}"/>" class="report text-gray-blue float-right"><i class="fa fa-flag" aria-hidden="true"></i></a>
													</p>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="post" items="${posts}">
									<c:choose>
										<c:when test="${post.answer != null}">
											<div class="col-12 content-panel answered">
										</c:when>
										<c:otherwise>
											<div class="col-12 content-panel">
										</c:otherwise>
									</c:choose>
										<div class="row">
											<c:choose>
												<c:when test="${post.author.file.getId() != null}">
													<a href="/profile/${post.author.id}">
														<img class="avatar" src="/imageDisplay?id=${post.author.id}" width=100px alt="User Avatar"/>
													</a>
												</c:when>
												<c:otherwise>
													<a href="/profile/${post.author.id}">
														<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="avatar">
													</a>
												</c:otherwise>
											</c:choose>
			
											<div class="col-sm-6">
												<h4><a href="/post/<c:out value="${post.id}"/>/show"><c:out value="${post.title}"/></a></h4>
												Uploaded Files:
												<c:forEach var="file" items="${post.attachments}">
													(<a href='/showFile/<c:out value="${file.id}"/>' target="_blank"><c:out value="${file.fileName}"/></a>)
												</c:forEach>
												<p>${show}</p>
											</div>
											<div class="col-sm-3">
												<i class="fa fa-tags"></i>
												<ul class="list-inline">
													<!-- Iterate through tags in each post -->
													<c:forEach var="tag" items="${post.tags}">
														<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/>"><c:out value="${tag.subject}"/></span></li>
													</c:forEach>
												</ul>
											</div>
											<div class="col-sm-1">
												<a href="#" class="like text-gray-blue"><i class="fa fa-thumbs-up float-right"></i></a>
											</div>
										</div>
										<div class="row">
											<div class="container">
												<div class="col-12">
													<p class="line-breaks"><c:out value="${post.content}"/></p>
												</div>
												<div class="col-12">
													<!-- Total comments and show -->
													<p>
														<c:out value="${post.comments.size()}"/> Comments 
														<a href="" data-toggle="modal" data-target="#reportModal" data-report-id="<c:out value="${post.id}"/>" class="report text-gray-blue float-right"><i class="fa fa-flag" aria-hidden="true"></i></a>
													</p>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
							
						</c:choose>
						</div>

						<!-- Pagination -->
						<c:if test="${totalPages > 1}">
							<nav>
								<ul class="pagination justify-content-center">
									<c:if test="${ pageNumber != 1 }">
											<li class="page-item"><a class="page-link" href="/pages/${pageNumber - 1}">&laquo;</a></li>
									</c:if>
									
									<!--
										Create a variable that will increment through the forEach loop
										to prevent from the next button in pagination appear as there is no more content
									-->
									<c:set var="next" scope="application" value="${0}"/>
									
									<c:forEach begin="1" end="${totalPages}" var="index">
										<c:choose>
											<c:when test="${pageNumber == index}">
												<li class="page-item active"><a class="page-link" href="/pages/${index}">${index}</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link" href="/pages/${index}">${index}</a></li>
											</c:otherwise>
										</c:choose>
										<c:set var="next" scope="application" value="${ next + 1}"/>
									</c:forEach>
									<c:if test="${ pageNumber != next }">
										<li class="page-item"><a class="page-link" href="/pages/${pageNumber + 1}">&raquo;</a></li>
									</c:if>
								</ul>
							</nav>
						</c:if>		
						
					</div>
				</div>
			</div>
			<!-- Announcements, leaderboards, quicklinks -->
			<%@ include file = "snippets/sidebar.jsp" %>
		</div>
		
		<!-- New Post Modal -->
		<%@ include file = "snippets/newPost.jsp" %>
		
		<!-- Settings Modal -->
		<%@ include file = "snippets/settings.jsp" %>
		
		<!-- Help Modal -->
		<%@ include file = "snippets/help.jsp" %>

		<!-- Quicklink Modal -->
		<%@ include file = "snippets/quicklinks.jsp" %>

		<!-- Feedback Modal -->
		<%@ include file = "snippets/feedback.jsp" %>
			
		<!-- Report Modal -->
		<%@ include file = "snippets/report.jsp" %>

		
		
	</body>
</html>
