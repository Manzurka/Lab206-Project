package com.lab206.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.lab206.models.Post;
import com.lab206.repositories.CommentRepository;
import com.lab206.repositories.PostRepository;
import com.lab206.repositories.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

	@Mock
	private PostRepository pr;
	
	private CommentRepository cr;
	
	private UserRepository ur;
	
	private PostService service;
	
	private Long postId;
	
	@Before
	public void setUp() {
		service = new PostService(pr, cr, ur);
		
		postId = 1L;
	}
	
	// allPosts
	@Test
	public void testAllPost() {
		List<Post> posts = new ArrayList<>();
		posts.add(new Post());
		
		Mockito.when(pr.findAll()).thenReturn(posts);
		
		List<Post> result = service.allPosts();
		
		Assert.assertEquals(1, result.size());
	}
	
	@Test
	public void testAllPostEmpty() {
		List<Post> posts = new ArrayList<>();
		
		Mockito.when(pr.findAll()).thenReturn(posts);
		
		List<Post> result = service.allPosts();
		
		Assert.assertEquals(0, result.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void testAllPostException() {
		Mockito.when(pr.findAll()).thenThrow(RuntimeException.class);
		
		List<Post> result = service.allPosts();
	}
	
	// allPostsNew
	@Test
	public void testAllPostsNew() {
		List<Post> posts = new ArrayList<>();
		posts.add(new Post());
		
		Mockito.when(pr.findAllNew()).thenReturn(posts);
		
		List<Post> result = service.allPostsNew();
		
		Assert.assertEquals(1, result.size());
	}
	
	@Test
	public void testAllPostsNewEmpty() {
		List<Post> posts = new ArrayList<>();
		
		Mockito.when(pr.findAllNew()).thenReturn(posts);
		
		List<Post> result = service.allPostsNew();
		
		Assert.assertEquals(0, result.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void testAllPostNewException() {
		Mockito.when(pr.findAllNew()).thenThrow(RuntimeException.class);
		
		List<Post> result = service.allPostsNew();
	}
	
}
