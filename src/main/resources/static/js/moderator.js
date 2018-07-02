$('.c_feedback').click(function() {
	var displayFeedback = $(this).attr('data-feed-id');
	$.ajax({
		url: "/post/feedbacks/" + displayFeedback
	}).then(function(feed) {
		console.log(`Is this reviewed: ${feed.reviewed}`);
		$('#feedContent').html(feed.content);
		$('#feedRating').html(feed.rating);
		//$('img').attr('src', feed.file.data);
		$('#feedSubmitter').html(`${feed.feedbackCreator.firstName} ${feed.feedbackCreator.lastName}`);
		$('#feedReview').html(feed.reviewed);
		
		// Assigning the href to and grabbing the correct ID.
		//This is marking the correct Feedback as of being reviewed
		$('#reviewMark').attr("href", `/${feed.id}/reviewed`);
	});
});

const limitText = (text, count) => {
	text.slice(0, count) + (text.length > count ? "..." : "");
}
	
for(let i = 0; i < 5; i++) {
	console.log(document.getElementsByClassName('c_feedback')[i].innerHTML);
}



