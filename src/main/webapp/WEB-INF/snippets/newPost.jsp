<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- New Post modal -->
<div id="newPostModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">New Post</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form action="/post/create" modelAttribute="newPost" method="post" enctype="multipart/form-data">
                <div class="row mb-3">
                    <div class="col-6">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="courseRelated">Course Related</span>
                            </div>
                            <label class="switch">
                                <input type="checkbox" id="course" name="course" aria-describedby="courseRelated">
                                <span class="slider round"></span>
                            </label>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="newPostLanguage">Language</span>
                            </div>
                            <select class="form-control" id="language" name="language" aria-label="Language" aria-describedby="newPostLanguage">
                                <c:forEach var="language" items="${languages}">
                                    <option>${language}</option>
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
                    <input name="title" class="form-control" aria-label="Title" aria-describedby="newPost-title"/>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Tags</span>
                    </div>
                    <input type="text" class="form-control" id="tag1" name="tag1">
                    <input type="text" class="form-control" id="tag2" name="tag2">
                    <input type="text" class="form-control" id="tag3" name="tag3">
                </div>
                <form:errors path="content"/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Content</span>
                    </div>
                    <textarea name="content" class="form-control" aria-label="Content"></textarea>
                </div>
                <p>${filemessage}</p>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            
                            <span class="input-group-text">File#1</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" name="file" class="custom-file-input" id="inputGroupFile01">
                            <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">File#2</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" name="file" class="custom-file-input" id="inputGroupFile02">
                            <label class="custom-file-label" for="inputGroupFile02">Choose file</label>
                        </div>	
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">File#3</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" name="file" class="custom-file-input" id="inputGroupFile03">
                            <label class="custom-file-label" for="inputGroupFile03">Choose file</label>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">File#4</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" name="file" class="custom-file-input" id="inputGroupFile04">
                            <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">File#5</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" name="file" class="custom-file-input" id="inputGroupFile05">
                            <label class="custom-file-label" for="inputGroupFile05">Choose file</label>
                        </div>
                    </div>
                    <button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Submit</button>
                </form:form>
            </div>
        </div>
    </div>
</div>