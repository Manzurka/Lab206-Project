<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Settings Modal -->
<div id="settingsModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Settings</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form action="/user/edit" modelAttribute="user" method="post" enctype="multipart/form-data">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Avatar</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" name="avatar" class="custom-file-input" id="inputGroupFile01">
                            <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                        </div>
                    </div>
                    <form:errors path="firstName"/>
                    <form:errors path="lastName"/>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Name</span>
                        </div>
                        <input type="text" name="firstName" class="form-control" value="<c:out value="${currentUser.firstName}"/>">
                        <input type="text" name="lastName" class="form-control" value="<c:out value="${currentUser.lastName}"/>">
                    </div>
                    <form:errors path="email"/>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Email</span>
                        </div>
                        <input type="text" class="form-control" name="email" aria-label="Email" aria-describedby="basic-addon1" value="<c:out value="${currentUser.email}"/>">
                    </div>
                    <form:errors path="about"/>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">About Me<br>(Optional)</span>
                        </div>
                        <textarea name="about" placeholder='<c:out value="${currentUser.about}"/>'  class="form-control" aria-label="AboutMe"><c:out value="${currentUser.about}"/></textarea>
                    </div>
                    <form:errors path="passwordConfirmation"/>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Password Confirmation</span>
                        </div>
                        <input type="password" name="passwordConfirmation" class="form-control" aria-label="PC"/>
                    </div>
                    <button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
                </form:form>
            </div>
        </div>
    </div>
</div>