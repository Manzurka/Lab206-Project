<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Report Modal -->
<div id="reportModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title">File a Report</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                        <p>
                            If this post or comment(s) related have abusive or 
                            unprofessional content, please submit your report. 
                            We will review the content and remove anything that does not follow 
                            our platform's Rules and Etiquette found on the help page.
                        </p>
                                                    
                        <form:form method="POST" action="/create/report" modelAttribute="reportForm">	

                         <div align="center">
                            <textarea name="content" id="content" rows="4" cols="50"></textarea>
                            
                            <br/>
                            <br/>
                            
                            <input type="submit" class="btn bg-cosmic-cobalt text-ghost-white" value="Submit"/>
                         </div>
                            
                            <!-- Displaying an hidden input to grab the post ID and also displaying the input type='submit' button -->
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            
                            <div id="reportsf"/>
                            
                        </form:form>
                </div>
            </div>
        </div>
    </div>