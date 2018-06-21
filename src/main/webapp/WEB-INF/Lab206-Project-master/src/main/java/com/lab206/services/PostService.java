package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.models.Post;
import com.lab206.models.User;
import com.lab206.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository pr;
	
	public PostService(PostRepository pr) {
		this.pr = pr;
	}
	
	public List<Post> allPosts() {
		return pr.findAll();
	}
	
	public List<Post> allPostsNew() {
		return pr.findAllNew();
	}
	
	public void createPost(Post post) {
		pr.save(post);
	}
	
	public List<Post> recentPosts(User user) {
		return pr.findRecentPosts(user);
	}
}
