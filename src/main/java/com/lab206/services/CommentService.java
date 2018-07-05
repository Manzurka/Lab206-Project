package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.repositories.CommentRepository;
import com.lab206.repositories.PostRepository;
import com.lab206.repositories.UserRepository;

@Service
public class CommentService {

	private CommentRepository cr;
	private PostRepository pr;
	private UserRepository ur;
	
	public CommentService(CommentRepository cr,
			PostRepository pr,
			UserRepository ur) {
		this.cr = cr;
		this.pr = pr;
		this.ur = ur;  
	}
	
	public Comment createComment(Comment comment,
			Post post,
			User user) {
		comment.setPost(post);
		post.addComment(comment);
		pr.save(post);
		comment.setCommenter(user);
		return cr.save(comment);
	}
	
	public List<Comment> findAll() {
		return cr.findAll();
	}
	
	public List<Comment> findByPostDesc(Post post) {
		return cr.findByPostDesc(post);
	}
	
	public Comment findById(Long id) {
		return cr.findById(id).get();
	}
	
	public void likeComment(Comment comment,
			User user) {
		user.addLikedComment(comment);
		ur.save(user);
	}
	
	public void removeLikedComment(Comment comment,
			User user) {
		user.removeLikedComment(comment);
		ur.save(user);
	}
	
	public void dislikeComment(Comment comment,
			User user) {
		user.addDislikedComment(comment);
		ur.save(user);
	}
	
	public void removeDislikedComment(Comment comment,
			User user) {
		user.removeDislikedComment(comment);
		ur.save(user);
	}
	
}
