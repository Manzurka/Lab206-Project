


$(document).ready(function(){
	// For displaying the number 5 within the range input inside of the Feedback Modal
	document.getElementById('range_weight_disp').innerHTML = 5;
	
	
	
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
		$('#commentPostId').attr('value', post.id);
	}	
	// Appends comments w/o updated at
	var showCommentsNoUpdates = function(comment, author) {
		$.when($.ajax("/comment/get/" + comment.id + "/commenter")).promise().done(function(commenter) {
			$('#showComments').append(`
				<div class="col-sm-11 offset-sm-1 mb-3" id="">
					<ul class="list-inline float-right">
						<li class="list-inline-item"><a href="" class="unliked"><i class="fas fa-sun fa-lg float-right"></i></a></li>
					</ul>
					<h5>${commenter} replying to ${author.firstName}</h5>
					<p>${comment.content}</p>
					<ul class="time-list">
						<li>Created At: ${comment.createdAt}</li>
					</ul>
				</div>
			`).promise().done();
		});
	}	
	// Appends comments with updated at
	var showCommentsWithUpdates = function(comment, author) {
		$.when($.ajax("/comment/get/" + comment.id + "/commenter")).promise().done(function(commenter) {
			$('#showComments').append(`
				<div class="col-sm-11 offset-sm-1 mb-3" id="">
					<ul class="list-inline float-right">
						<li class="list-inline-item"><a href="" class="unliked"><i class="fas fa-sun fa-lg float-right"></i></a></li>
					</ul>
					<h5>${comment.commenter.firstName} replying to ${author.firstName}</h5>
					<p>${comment.content}</p>
					<ul class="time-list">
						<li>Created At: ${comment.createdAt}</li>
						<li>Last Edit: ${comment.updatedAt}</li>
					</ul>
				</div>
			`).promise().done();
		});
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
				commentUpdated(comments[i], author);
			}
		});
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
		$('#showComments').html(``);
		$.when($.ajax("/post/show/" + $(this).attr('data-post-id')).done(function(post) {
			console.log(post);
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
		$('#showPostModal').modal('show');
	});
	$(".shoe-project").click(function(){
		console.log("potato");
		$.ajax({
//			type: "POST",
			url: "/project/get/" + $(this).attr("data-project-id")
		}).promise().done().then(function(proj) {
			console.log("potato2")
			var url = '/project/' + proj.id + '/update'
			$('#projEdit').attr('action', url);
//			$('#projectEdit23').html(`
//					<form action="/project/update" method="post" enctype="multipart/form-data" >
//					<input type="hidden" name="${csrfParam}" value="${csrfToken}"/>
//
//					<input type="hidden" id="id" value="${proj.id}">
//						<div class="modal-header">						
//							<h2 class="modal-title">Edit Project</h2>
//							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
//								<span aria-hidden="true">&times;</span>
//							</button>
//						</div>
//						<div class="modal-body">
//							<div class="input-group mb-3">
//								<div class="input-group-prepend">
//									<span class="input-group-text">Thumbnail</span>
//								</div>
//								<div class="custom-file">
//									<input name="thumbnail" type="file" class="custom-file-input" id="inputGroupFile01">
//									<label class="custom-file-label" for="inputGroupFile01">Choose file for Project</label>
//								</div>
//							</div>
//							<div class="input-group mb-3">
//								<div class="input-group-prepend">
//									<span class="input-group-text">About this Project</span>
//								</div>
//								<form:errors path="about"/>
//								<textarea id="text" name="about" class="form-control" placeholder="${proj.about}"></textarea>
//							</div>
//							<button type="submit" class="btn bg-cosmic-cobalt text-ghost-white float-right">Save</button>
//						</div>
//					</form>
//				`)	
		});
		$('#projectsModal').modal('show');
	});
	
// edit function to retrieve info from database 
	// $(".testingEdit").click(function(){
	// 	var postid = $(this).attr('data-post-id')
	// 	$.ajax({
	// 		url: "/post/show/" + postid
	// 	}).then(function(post) {
	// 		console.log(post);
	// 		console.log("testing" + JSON.stringify(post.tags,null,'\t'));
	// 			if (post.tags[0].subject == "coursework") {
	// 				$('#currentCourse').attr(`checked`, "true"); 
	// 				$('#currentLanguage').val(`${post.tags[1].subject}`);
	// 				for (var i=2; i<post.tags.length; i++) {
	// 					var tag = "#currentTag" + (i-1);
	// 					$(tag).val(`${post.tags[i].subject}`);
	// 				}
	// 			} 
	// 			else {
	// 				$('#currentCourse').removeAttr(`checked`); 
	// 				$('#currentLanguage').val(`${post.tags[0].subject}`);
	// 				for (var i=1; i<post.tags.length; i++) {
	// 					var tag = "#currentTag" + i;
	// 					$(tag).val(`${post.tags[i].subject}`);
	// 				}
	// 			}
	// 				$('#currentTitle').val(`${post.title}`);
	// 				$('#currentContent').html(`${post.content}`);
	// 				$('#currentInputGroupFile01').val(`${post.file}`);
	// 				$('#currentInputGroupFile02').val(`${post.file}`);
	// 				$('#currentInputGroupFile03').val(`${post.file}`);
	// 				$('#currentInputGroupFile04').val(`${post.file}`);
	// 				$('#currentInputGroupFile05').val(`${post.file}`);
	// 	});
	// })

	// Uses ajax to create a new comment and append to current comments
	$('#newCommentForm').submit(function(event) {
		event.preventDefault();
		comment = $(this).serialize();
		document.getElementById("newCommentForm").reset();
		$.ajax({
			type: "POST",
			url: "/comment/create",
			data: comment
		}).then(function(com) {
			console.log(com)
			$('#showComments').append(`
			<div class="row">
				<div class="col-sm-12">
					<h5>${com.commenter.firstName} replying to ${com.post}</h5>
					<p class="line-breaks">${com.content}</p>
					<ul class="time-list">
						<li>Created At: ${com.createdAt}</li>
					</ul>
				</div>
			</div>
			<hr>
		`);
		})
	});
	
	

});