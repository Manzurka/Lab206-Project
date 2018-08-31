package com.lab206.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lab206.models.Announcement;
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
	
	// tested
	public List<Comment> findAll() {
		return cr.findAll();
	}
	
	public List<Comment> findByPostDesc(Post post) {
		return cr.findByPostDesc(post);
	}
	
	//tested
	public Comment findById(Long id) {
		Optional <Comment> comment = cr.findById(id);
		return comment.isPresent() ? comment.get() : null;
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
	
	public List<Comment> commentsContaining(String keyword){
		return cr.findByContentContaining(keyword);
	}
	
}
