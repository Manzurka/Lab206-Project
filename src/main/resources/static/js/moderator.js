$('.c_feedback').click(function() {
	var displayFeedback = $(this).attr('data-feed-id');
	$.ajax({
		url: "/post/feedbacks/" + displayFeedback
	}).then(function(feed) {
		console.log("Is this reviewed: " + feed.reviewed);
		$('#feedContent').html(feed.content);
		$('#feedRating').html(feed.rating);
		$('#feedSubmitter').html(feed.feedbackCreator.firstName + ' ' + feed.feedbackCreator.lastName);
		$('#feedReview').html(feed.reviewed);
	});
});

const limitText = (text, count) => {
	text.slice(0, count) + (text.length > count ? "..." : "");
}

console.log("Test: "+ document.getElementById('feedContent').innerHTML)
limitText(document.getElementById('feedContent').innerHTML, 40);

