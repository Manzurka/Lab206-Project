<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Feedback Modal -->
<div id="f" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Submit Feedback</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                
                    <p>Please provide feedback on how we can improve Teccy Space or if something is not working.</p>
                    
                <form:form method="POST" action="/create/feedback" modelAttribute="feedb">	
                    
                    <textarea name="content" class="form-control" aria-label="Content"></textarea>
                    
                    <br>
                    
                    <label path="rating">Rate Feedback:
                    <input 
                        name="rating"
                        type="range"
                        class="custom-range"
                        value="5"
                        min="1"
                        max="10"
                        oninput="range_weight_disp.value = range_weight.value"
                    />
                    <output id="range_weight_disp"></output>
                    
                    </label>
                    
                    
                    
                    <input type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right" value="Submit"/>
                
                </form:form>
            </div>
        </div>
    </div>
</div>