
// ALL FEEDBACK
$('.c_feedback').click(function() {
	let displayFeedback = $(this).attr('data-feed-id');
	$.ajax({
		url: "/post/feedbacks/" + displayFeedback
	}).then(function(feed) {
		console.log(`Is this reviewed: ${feed.reviewed}`);
		$('#feedContent').html(feed.content);
		$('#feedRating').html(feed.rating);
		$('#feedSubmitter').html(`${feed.feedbackCreator.firstName} ${feed.feedbackCreator.lastName}`);
		
		if (!feed.reviewed) {
			// Assigning the href to and grabbing the correct ID.
			//This is marking the correct Feedback as of being reviewed
			$('#reviewMark').html('<a>Mark as Reviewed</a>');
			$('#reviewMark').attr("href", `/feedback/${feed.id}/reviewed`);
			$('#reviewMark').addClass('btn reviewedButton');
			$('#feedReview').html(feed.reviewed);
		}
		else {
			$('#reviewMark').html(`<span>This Feedback has been reviewed by ${feed.feedbackResolver}</span>`);
			$('#reviewMark').removeClass();
			$('#reviewMark').removeAttr( "href" )
		}
		
		$('#feedReview').html(feed.reviewed);
		
		
				
	});
});



// ALL REPORTS
$('.c_report').click(function() {
	let displayReport = $(this).attr('data-report-id');
	$.ajax({
		url: "/post/reports/" + displayReport
	}).then(function(report) {
		$('#reportContent').html(report.content);
		$('#reporter').html(`${report.reporter.firstName} ${report.reporter.lastName}`);
		$('#userReported').html(`${report.reported.firstName} ${report.reported.lastName}`);
		$('#reportReview').html(report.reviewed);
	
		
		// Assigning the href to and grabbing the correct ID.
		//This is marking the correct Report as of being reviewed
		$('#reportMarkedAsReviewed').attr("href", `/report/${report.id}/reviewed`);
	});
});

const limitText = (text, count) => {
	text.slice(0, count) + (text.length > count ? "..." : "");
}


// For Displaying the loading screen
let counter;

const loaderDuration = () => {
	// Loader displays on the screen for 0.5 seconds
	counter = setTimeout(showPage, 500);
}

const showPage = () => {
  document.getElementById("loader").style.display = "none";
  document.getElementById("block").style.display = "block";
}

