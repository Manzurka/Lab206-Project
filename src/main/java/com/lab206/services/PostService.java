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
public class PostService {

	private PostRepository pr;
	private CommentRepository cr;
	private UserRepository ur;
	
	public PostService(PostRepository pr, CommentRepository cr, UserRepository ur) {
		this.pr = pr;
		this.cr = cr;
		this.ur = ur;
	}
<<<<<<< HEAD
	
	// tested
=======

>>>>>>> 191ed15bf46db6aae13adc1ede477a5bdbbbd7b1
	public List<Post> allPosts() {
		return pr.findAll();
	}
	
	//tested
	public List<Post> allPostsNew() {
		return pr.findAllNew();
	}
	
	public void setPostAuthor(User author, Post post) {
		post.setAuthor(author);
		pr.save(post);
	}
	
	public void createPost(Post post) {
		pr.save(post);
	}
	
	public void deletePost(Long id) {
		pr.deleteById(id);
	}
	
	public Post findPostById(Long id) {
		return pr.findById(id).get();
	}
	
	public void updatePost(Post post, User author) {
		post.setAuthor(author);
		cr.save(post);
	}
	
	public Post savePost(Post post) {
		return pr.save(post);
	}
	
	public Comment saveComment(Comment comment) {
		return cr.save(comment);
		}
	
	public List<Post> postsContaining(String keyword){
		return pr.findByContentOrTitleContaining(keyword);
	}
	
	public void likePost(User user,
			Post post) {
		post.addPostLike(user);
//		user.addLikedPosts(post);
		pr.save(post);
		ur.save(user);
	}
	
	public void unlikePost(User user,
			Post post) {
		post.removePostLike(user);
//		user.removeLikedPost(post);
		pr.save(post);
		ur.save(user);
	}
	
	public void markAnswer(Comment comment,
			Post post) {
		post.setAnswer(comment);
		comment.setQuestion(post);
		pr.save(post);
		cr.save(comment);
	}
}
