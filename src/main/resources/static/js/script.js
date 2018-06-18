$(document).ready(function(){
	// Finds user based off of ID
	var findUser = function(id) {
		$.ajax({
			url: "/user/get/" + id
		}).then(function(user) {
			return user;
		});
	}
	// Gets tags for post and arranges in a list
	var getTags = function(post) {
		var tags = `
		<ul class="list-inline">
			
		`;
		for (i = 0; i < post.tags.length; i++) {
			tags += `<li class="list-inline-item"><span class="badge badge-pill text-ghost-white ${post.tags[i].color}">${post.tags[i].subject}</span></li>`;
		}
		return tags;
	}	
	// Adds HTML for post title
	var postTitle = function(post, tags) {
		$('#postTitle').html(`
			<h2 class="modal-title">${post.title}</h2>
			${tags}
			</ul>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		`);
	}	
	//Adds HTML for author info
	var authorInfo = function(user) {
		$('#userInfo').html(`
			<img src="https://www.in-depthoutdoors.com/wp-content/themes/ido/img/ido-avatar.png" alt="User Avatar" class="post-avatar">
			<ul class="navbar-nav mr-auto">
				<li>Name: ${user.firstName} ${user.lastName}</li>
				<li>Patches: Some patches</li>
			</ul>
		`);
	}	
	// Adds HTML for post content
	var postContent = function(post) {
		$('#postContent').html(`
			<p>${post.content}</p>
			<p><i>Created At: ${post.createdAt}</i></p>
		`);
	}	
	// Adds post ID as hidden input to comment form
	var commentForm = function(post) {
		$('#newCommentForm').append(`
			<input type="hidden" value="${post.id}" name="postId">
		`);
	}	
	// Appends comments w/o updated at
	var showCommentsNoUpdates = function(comment, author) {
		$('#showComments').append(`
			<div class="col-sm-11 offset-sm-1 mb-3" id="">
    			<ul class="list-inline float-right">
					<li class="list-inline-item"><a href="" class="dislike"><i class="fas fa-snowflake fa-lg float-right"></i></a></li>
					<li class="list-inline-item"><a href="" class="like"><i class="fas fa-sun fa-lg float-right"></i></a></li>
				</ul>
    			<h5>${comment.commenter.firstName} replying to ${author.firstName}</h5>
    			<p>${comment.content}</p>
    			<ul class="time-list">
    				<li>Created At: ${comment.createdAt}</li>
    			</ul>
    		</div>
		`);
	}	
	// Appends comments with updated at
	var showCommentsWithUpdates = function(comment, author) {
		$('#showComments').append(`
			<div class="col-sm-11 offset-sm-1 mb-3" id="">
    			<ul class="list-inline float-right">
					<li class="list-inline-item"><a href="" class="dislike"><i class="fas fa-snowflake fa-lg float-right"></i></a></li>
					<li class="list-inline-item"><a href="" class="like"><i class="fas fa-sun fa-lg float-right"></i></a></li>
				</ul>
    			<h5>${comment.commenter.firstName} replying to ${author.firstName}</h5>
    			<p>${comment.content}</p>
    			<ul class="time-list">
    				<li>Created At: ${comment.createdAt}</li>
    				<li>Last Edit: ${comment.updatedAt}</li>
    			</ul>
    		</div>
		`);
	}
	// Checks to see if comment was updated
	var commentUpdated = function(comment, author) {
		if (comment.updatedAt != null) {
			showCommentsWithUpdates(comment, author);
		} else {
			showCommentsNoUpdates(comment, author);
		}
	}
	// Iterates through comments
	var getComments = function(post, author) {
		var comments = '';
		$.when($.ajax("/post/" + post.id + "/comments")).promise().done(function(coms) {
			comments = coms;
			console.log(comments);
			for (var i = 0; i < comments.length; i++) {
				if (typeof comments[i] == "number") {
					console.log(comments[i]);
					$.when($.ajax("/comment/get/" + post.comments[i])).promise().done(function(comment) {
						console.log(comment);
						commentUpdated(comment, author);
					})
				} else {
					commentUpdated(comments[i], author);
				}
			}
		}) ;
	}
	// Calls all of the functions to add HTML
	var addHTML = function(post, author) {
		var tags = getTags(post) + `</ul>`;
		postTitle(post, tags);
		authorInfo(author);
		postContent(post);
		commentForm(post);
		getComments(post, author);
	}
	$(document).on('click', '[class^="show-post"]', function() {
//		$('#showPostModal').html(``);
		$.when($.ajax("/post/show/" + $(this).attr('data-post-id')).done(function(post) {
			var author = '';
			if (typeof post.author == "number") {
				$.when($.ajax("/user/get/" + post.author)).promise().done(function(auth) {
					author = auth;
					addHTML(post, author);
				})
			} else if (typeof post.author != "number") {
				author = post.author;
				addHTML(post, author);
			}
		})).promise().done();
	});
	
})