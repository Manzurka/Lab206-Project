// Confirmation of removing a user

$('.remove').click(function() {
	let displayUser = $(this).attr('data-feed-id');
	$.ajax({
		url: "/user/get/" + displayUser
	}).then(function(user) {
		$('#name').html(`${user.firstName} ${user.lastName}`);
		$('#email').html(user.email);
		$('#points').html(user.points);
		$('#numberOfPosts').html(user.post.length);
		
		let d = new Date(user.createdAt);
		$('#createdAt').html(`${d.getMonth()+1}-${d.getDate()}-${d.getFullYear()}`);
		
		$('#conformation').attr("href", `/user/${ user.id }/delete`)
				
	});
});
