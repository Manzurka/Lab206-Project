
// FEEDBACK
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
		
		if (feed.reviewed !== true) {
			$('#reviewMark').html('<a>Mark as Reviewed</a>');
			$('#reviewMark').attr("href", `/feedback/${feed.id}/reviewed`);
			$('#reviewMark').addClass('btn reviewedButton');
			
		}
		else {
			$('#reviewMark').html('<span>This Feedback has been reviewed</span>');
			$('#reviewMark').removeClass();
			$('#reviewMark').removeAttr( "href" )
		}
		
		$('#feedReview').html(feed.reviewed);
		
		// Assigning the href to and grabbing the correct ID.
		//This is marking the correct Feedback as of being reviewed
		
		
				
	});
});



// REPORTS
$('.c_report').click(function() {
	var displayReport = $(this).attr('data-report-id');
	$.ajax({
		url: "/post/reports/" + displayReport
	}).then(function(report) {
		console.log(`Reporter: ${report.reporter.firstName}`);
		$('#reportContent').html(report.content);
		$('#reportBy').html(`${report.reported.firstName} ${report.reported.lastName}`);
		$('#reporter').html(`${report.reporter.firstName} ${report.reporter.lastName}`);
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

const counterFunction = () => {
	counter = setTimeout(showPage, 500);
}

const showPage = () => {
  document.getElementById("loader").style.display = "none";
  document.getElementById("block").style.display = "block";
}

