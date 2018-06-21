package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.models.Comment;
import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.repositories.CommentRepository;
import com.lab206.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository pr;
	private CommentRepository cr;
	
	public PostService(PostRepository pr) {
		this.pr = pr;
		this.cr = cr;
	}
	
	public List<Post> allPosts() {
		return pr.findAll();
	}
	
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
	
	public void updatePost(Post post, User author) {
		post.setAuthor(author);
		cr.save(post);
	}
	
	public Post findPostById(Long id) {
		return pr.findById(id).get();
	}
	
	public Post savePost(Post post) {
		return pr.save(post);
	}
	
	public Comment saveComment(Comment comment) {
	return cr.save(comment);
	}
}