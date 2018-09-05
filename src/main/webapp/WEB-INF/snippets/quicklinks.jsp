<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Quicklink Modal -->
<div id="quicklinkModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Submit Quicklink</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Submit a new quicklink for one of our moderators to review.</p>
                <form:form method="POST" action="/quicklink/create" modelAttribute="quicklink">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="newPostLanguage">Language</span>
                        </div>
                        <select class="form-control" name="quicklinkLanguage" aria-label="Quicklink Language" aria-describedby="Quicklink Language">
                            <c:forEach var="language" items="${languages}">
                                <option>${language}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">	
                            <span class="input-group-text" id="newPost-title">Name</span>
                        </div>
                        <form:input path="name" class="form-control" aria-label="Quicklink Name" aria-describedby="Quicklink Name"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">	
                            <span class="input-group-text" id="newPost-title">URL</span>
                        </div>
                        <form:input path="url" class="form-control" aria-label="Quicklink URL" aria-describedby="Quicklink URL"/>
                    </div>
                    <input type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right" value="Submit"/>
                </form:form>
            </div>
        </div>
    </div>
</div>