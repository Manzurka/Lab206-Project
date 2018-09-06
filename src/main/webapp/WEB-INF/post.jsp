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
							<c:when test="${currentUser == post.author}">
								<a href="/post/<c:out value="${post.id}"/>/delete" class="text-gray-blue float-right post-header"><i class="far fa-trash-alt" aria-hidden="true"></i></a>
								<span class="float-right">&nbsp;&nbsp;</span>
								<a href="/post/<c:out value="${post.id}"/>/edit" data-toggle="modal" data-target="#editModal" id="editIdPost" class="edit text-gray-blue testingEdit float-right post-header"><i class="fa fa-edit" aria-hidden="true"></i></a>		
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${currentUser.likedPosts.contains(post)}">
										<a href='/post/<c:out value="${post.id}"/>/unlike' class="liked post-header"><i class="fa fa-thumbs-up"></i></a>
									</c:when>
									<c:otherwise>
										<a href='/post/<c:out value="${post.id}"/>/like' class="like post-header"><i class="fa fa-thumbs-up"></i></a>
									</c:otherwise>
								</c:choose>
								<span class="float-right">&nbsp;&nbsp;</span>
								<span class="text-ghost-white small float-right post-header"><c:out value="${post.postLikes.size()}"/></span>
							</c:otherwise>
						</c:choose>
						<h1 class="text-ghost-white"><c:out value="${post.title}"/></h1>
						<c:forEach var="tag" items="${post.tags}">
							<li class="list-inline-item"><span class="badge badge-pill text-ghost-white <c:out value="${tag.color}"/> post-footer"><c:out value="${tag.subject}"/></span></li>
						</c:forEach>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 offset-md-1 rounded-top content-panel">
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
							<div class="col-sm-3">
								<ul class="navbar-nav mr-auto">
									<li class="nav-item"><strong>Name:</strong> <c:out value="${post.author.firstName} ${post.author.lastName}"/></li>
									<li class="nav-item"><strong>Points:</strong> <c:out value="${post.author.points}"/></li>
									<li class="nav-item">
										<c:forEach var="badge" items="${post.author.badges}" begin="0" end="4">
											<img class="badge-img-sm" src="/badgeImage?id=${badge.id}">
										</c:forEach>
									</li>
								</ul>
							</div>
							<div class="col-sm-7">
								<i class="far fa-folder-open"></i>
								<!-- Iterate through tags in each post -->
								<c:forEach var="file" items="${post.attachments}">
									(<a href='/showFile/<c:out value="${file.id}"/>' target="_blank"><c:out value="${file.fileName}"/></a>)&nbsp;
									<c:if test="${post.author == currentUser}">
									 <a href="/showFile/<c:out value="${post.id}"/><c:out value="${file.id}"/>/delete" class="shoe-project text-gray-blue"><i class="fa fa-trash" aria-hidden="true"></i></a>
									</c:if>
								</c:forEach>
							</div>
						</div>
						<hr>
						<div class="row mb-3">
							<div class="col-sm-12">
								<p class="line-breaks"><c:out value="${post.content}"/></p>
								<a href="" data-toggle="modal" data-target="#reportModal" class="report"><i class="fa fa-flag" aria-hidden="true"></i></a>
								<ul class="time-list">
									<li class="nav-item">Created At: <fmt:formatDate type="both" 
										dateStyle="short" timeStyle="short" value="${post.createdAt}"/></li>
									<c:if test="${post.updatedAt != null}">
										<li class="nav-item">Last Edit: <fmt:formatDate type="both" 
											dateStyle="short" timeStyle="short" value="${post.updatedAt}"/></li>
									</c:if>
								</ul>
							</div>
						</div>
						<div class="row mb-3">
							<!-- New Comment form -->
							<div class="col-sm-12" id="newComment">
								<form:form method="post" action="/comment/create" modelAttribute="newComment">
									<input type="hidden" value="${post.id}" name="postId" id="commentPostId">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Content</span>
										</div>
										<form:textarea path="content" placeholder="Enter comment here" class="form-control" aria-label="Comment text"/>
									</div>
									<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
								</form:form>
							</div>
						</div>
						<!-- Show comments -->
						<div id="showComments">
							<c:if test="${post.answer != null}">
								<div class="row">
									<div class="col-sm-12 answered">
										<a href="" class="like"><i class="fas fa-thumbs-up"></i></a>
										<h5><c:out value="${post.answer.commenter.firstName}"/> replying to <c:out value="${post.author.firstName}"/></h5>
										<p class="line-breaks"><c:out value="${post.answer.content}"/></p>
										<ul class="time-list">
											<li>Created At: <fmt:formatDate type="both" 
												dateStyle="short" timeStyle="short" value="${post.answer.createdAt}"/></li>
											<c:if test="${post.answer.updatedAt != null}">
												<li>Last Edit: <fmt:formatDate type="both" 
													dateStyle="short" timeStyle="short" value="${post.answer.updatedAt}"/></li>
											</c:if>
										</ul>
									</div>
								</div>
								<hr>
							</c:if>
							<c:forEach var="comment" items="${post.comments}">
								<c:if test="${comment != post.answer}">
									<div class="row">
										<div class="col-sm-12">
											<c:if test="${currentUser != comment.commenter}">
												<c:if test="${currentUser == post.author && post.answer == null}">
													<a href='/post/<c:out value="${post.id}"/>/answer/<c:out value="${comment.id}"/>' class="answer"><i class="fas fa-check-circle"></i></a>
													<span class="float-right">&nbsp;&nbsp;</span>
												</c:if>
												<c:choose>
													<c:when test="${comment.commentLikes.contains(currentUser)}">
														<a href='/comment/<c:out value="${comment.id}"/>/unlike' class="liked"><i class="fas fa-thumbs-up"></i></a>
													</c:when>
													<c:otherwise>
															<a href='/comment/<c:out value="${comment.id}"/>/like' class="like"><i class="fas fa-thumbs-up"></i></a>
													</c:otherwise>
												</c:choose>
												<span class="float-right">&nbsp;&nbsp;</span>
												<span class="small float-right"><c:out value="${comment.commentLikes.size()}"/></span>
											</c:if>
											<h5><c:out value="${comment.commenter.firstName}"/> replying to <c:out value="${post.author.firstName}"/></h5>
											<p class="line-breaks"><c:out value="${comment.content}"/></p>
											<ul class="time-list">
												<li>Created At: <fmt:formatDate type="both" 
													dateStyle="short" timeStyle="short" value="${comment.createdAt}"/></li>
												<c:if test="${comment.updatedAt != null}">
													<li>Last Edit: <fmt:formatDate type="both" 
														dateStyle="short" timeStyle="short" value="${comment.updatedAt}"/></li>
												</c:if>
											</ul>
										</div>
									</div>
									<hr>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!-- Announcements, leaderboards, quicklinks -->
			<%@ include file = "snippets/sidebar.jsp" %>
		</div>
		
		<!-- Edit modal -->
		<div id="editModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h2 class="modal-title">Edit Post</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form:form action="/post/${post.id}/edit" modelAttribute="post" method="post" enctype="multipart/form-data" id="editIdPost">
						<div class="row mb-3">
							<div class="col-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text" id="courseRelated">Course Related</span>
									</div>
									<label class="switch">
										<c:set var="courserelated" value="false"/>
										<c:choose>
											<c:when test="${post.tags[0].subject == 'coursework'}">
												<c:set var="courserelated" value="true"/>
												<input type="checkbox" id="currentCourse" name="currentCourse" aria-describedby="courseRelated" checked="true">
											</c:when>
											<c:otherwise>
												<input type="checkbox" id="currentCourse" name="currentCourse" aria-describedby="courseRelated">
											</c:otherwise>
										</c:choose>
										<span class="slider round"></span>
									</label>
								</div>
							</div>
							<div class="col-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text" id="newPostLanguage">Language</span>
									</div>
									<c:set var="language" value="1"/>
									<c:choose>
										<c:when test="${courserelated}">
											<c:set var="language" value="1"/>
										</c:when>
										<c:otherwise>
											<c:set var="language" value="0"/>
										</c:otherwise>
									</c:choose>
									<select class="form-control" id="currentLanguage" name="currentLanguage" aria-label="Language" aria-describedby="newPostLanguage">
										<c:forEach var="lang" items="${languages}">
											<c:choose>
												<c:when test="${post.tags[language].subject == lang.toLowerCase()}">
													<option selected="selected" value="<c:out value="${lang.toLowerCase()}"/>"><c:out value="${lang}"/></option>
												</c:when>
												<c:otherwise>
													<option value="<c:out value="${lang}"/>"><c:out value="${lang}"/></option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
			            <form:errors path="title"/>
							<div class="input-group mb-3">
								<div class="input-group-prepend">	
									<span class="input-group-text" id="newPost-title">Title</span>
								</div>
								<form:input path="title" name="title" id="currentTitle" class="form-control" aria-label="Title"/>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Tags</span>
								</div>
								<c:set var="tagNum" value="1"/>
								<c:forEach var="tagIndex" begin="${language + 1}" end="${language + 3}">
									<c:choose>
										<c:when test="${post.tags[tagIndex] != null}">
											<input type="text" class="form-control" id="tag<c:out value="${tagNum}"/>" name="tag<c:out value="${tagNum}"/>" value="<c:out value="${post.tags[tagIndex].subject}"/>">
										</c:when>
										<c:otherwise>
											<input type="text" class="form-control" id="tag<c:out value="${tagNum}"/>" name="tag<c:out value="${tagNum}"/>">
										</c:otherwise>
									</c:choose>
									<c:set var="tagNum" value="${tagNum + 1}"/>
								</c:forEach>
							</div>
							<form:errors path="content"/>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Content</span>
								</div>
								<form:textarea path="content" name="content" id="currentContent" class="form-control" aria-label="Content"/>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									
									<span class="input-group-text">File#1</span>
								</div>
								<div class="custom-file">
									<input type="file" name="file1" class="custom-file-input" id="currentInputGroupFile01">
									<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
								</div>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">File#2</span>
								</div>
								<div class="custom-file">
									<input type="file" name="file2" class="custom-file-input" id="currentInputGroupFile02">
									<label class="custom-file-label" for="inputGroupFile02">Choose file</label>
								</div>	
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">File#3</span>
								</div>
								<div class="custom-file">
									<input type="file" name="file3" class="custom-file-input" id="currentInputGroupFile03">
									<label class="custom-file-label" for="inputGroupFile03">Choose file</label>
								</div>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">File#4</span>
								</div>
								<div class="custom-file">
									<input type="file" name="file4" class="custom-file-input" id="currentInputGroupFile04">
									<label class="custom-file-label" for="inputGroupFile04">Choose file</label>
								</div>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">File#5</span>
								</div>
								<div class="custom-file">
									<input type="file" name="file5" class="custom-file-input" id="currentInputGroupFile05">
									<label class="custom-file-label" for="inputGroupFile05">Choose file</label>
								</div>
							</div>
							<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
						</form:form>
			    	</div>
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
