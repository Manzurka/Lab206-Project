$(document).ready(function(){

	$('.collapsible').click(function() {
		var target = $(this).attr('data-target-div');
		if (target == 'announcements') {
			if ($('#announcements').is(':visible')) {
				$('#announcements').slideUp();
			}
			else {
				$('#announcements').slideDown();
			}
		}
		else if (target == 'leaderboard') {
			if ($('#leaderboard').is(':visible')) {
				$('#leaderboard').slideUp();
			}
			else {
				$('#leaderboard').slideDown();
			}
		}
		else if (target == 'quicklinks') {
			if ($('#quicklinks').is(':visible')) {
				$('#quicklinks').slideUp();
			}
			else {
				$('#quicklinks').slideDown();
			}
		}
	});

	$('.clickable-row').click(function() {
		var href = $(this).attr('data-href');
		$(location).attr('href', href);
	});
	
	//When the report flag is clicked, this grabs its post ID in allowing us to fetch the author of the post name and email
	$('.report').click(function() {
		let displayReport = $(this).attr('data-report-id');
		// Displaying an hidden input to grab the post ID
		$('#reportsf').html(`<input type="hidden" value=${displayReport} name="post_id" />`)
	});
	
	
	// For the Feedback range slider as this continues to update the value
	let rangeSlider = function(){
	  let slider = $('.range-slider'),
	      range = $('.range-slider__range'),
	      value = $('.range-slider__value');

	  slider.each(function(){

	    value.each(function(){
	      let value = $(this).prev().attr('value');
	      $(this).html(value);
	    });

	    range.on('input', function(){
	      $(this).next(value).html(this.value);
	    });
	  });
	};

	rangeSlider();
	
		
	// Finds user based off of ID
	var findUser = function(id) {
		$.ajax({
			url: "/user/get/" + id
		}).then(function(user) {
			return user;
		});
	}
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

	$('.quicklinkDropdown').click(function(event) {
		event.preventDefault();
		$.ajax({
			url: "/quicklink/filter/" + $(this).attr('data-language')
		}).then(function(quicklinks) {
			$('#quicklinkList').html(``);
			var color = quicklinks[0].tags[0].color;
			var subject = quicklinks[0].tags[0].subject;
			for (i = 0; i < quicklinks.length; i++) {
				$('#quicklinkList').append(`
					<li>
						<a target="_blank" href="${quicklinks[i].url}">${quicklinks[i].name}</a>
						<span class="badge badge-pill text-ghost-white ${color} post-footer">${subject}</span>
					</li>
				`)
			};
		});
	});
	
	
	// For displaying the number 5 within the range input inside of the Feedback Modal
	document.getElementById('range_weight_disp').innerHTML = 5;
	
	

});
