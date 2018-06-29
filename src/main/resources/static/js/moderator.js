$('.c_feedback').click(function() {
	var displayFeedback = $(this).attr('data-feed-id');
	$.ajax({
		url: "/post/feedbacks/" + displayFeedback
	}).then(function(feed) {
		console.log(feed);
		console.log("Is this reviewed: " + feed.reviewed);
		$('#feedContent').html(feed.content);
		$('#feedRating').html(feed.rating);
		$('#feedSubmitter').html(feed.feedbackCreator.firstName + ' ' + feed.feedbackCreator.lastName);
		$('#feedReviewed').html(feed.reviewed);
	});
});