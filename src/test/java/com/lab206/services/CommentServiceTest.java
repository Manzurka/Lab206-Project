package com.lab206.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.lab206.repositories.CommentRepository;
import com.lab206.repositories.PostRepository;
import com.lab206.repositories.UserRepository;
import com.lab206.models.Comment;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {
	
	private static final Object Comment = null;
	
	@Mock
	private CommentRepository cr;
	
	private PostRepository pr;
	
	private UserRepository ur;
	
	private CommentService cs;
	
	private Long commentId;
	
	@Before
	public void setUp() {
		cs = new CommentService(cr, pr, ur);
		
		commentId = 1L;
	}
	
	// findAll
	@Test
	public void testAllComments() {
		List<Comment> comments = new ArrayList<>();
		comments.add(new Comment());
		comments.add(new Comment());
		
		Mockito.when(cr.findAll()).thenReturn(comments);
		
		List<Comment> result = cs.findAll();
		
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void testFindAllEmpty() {
		List<Comment> comments = new ArrayList<>();
		
		Mockito.when(cr.findAll()).thenReturn(comments);
		
		List<Comment> result = cs.findAll();
		
		Assert.assertEquals(0, result.size());
	}
	
	@Test(expected = RuntimeException.class)
	public void testFindAllException() {
		Mockito.when(cr.findAll());
		
		cs.findAll();
	}
	
	//findByPostDesc
	@Test
	public void testFindByPostDesc() {
		List<Comment> comments = new ArrayList<>();
		comments.add(new Comment());
		comments.add(new Comment());
		
		Mockito.when(cr.findByPostDesc(null)).thenReturn(comments);
		
		List<Comment> result = cs.findByPostDesc(null);
		
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	public void testFindByPostDescEmpty() {
		List<Comment> comments = new ArrayList<>();
		
		Mockito.when(cr.findByPostDesc(null)).thenReturn(comments);
		
		List<Comment> result = cs.findByPostDesc(null);
		
		Assert.assertEquals(0, result.size());
	}
	
	//findById
	@Test
	public void testFindByIdSuccessful() {
		Optional<Comment> optional = Optional.of(new Comment());
		Mockito.when(cr.findById(commentId)).thenReturn(optional);
		Comment comment = cs.findById(commentId);
		Assert.assertNotNull(comment);
	}
	
	@Test
	public void testFindByIdEmpty() {
		Optional<Comment> optional = Optional.empty();
		Mockito.when(cr.findById(commentId)).thenReturn(optional);
		Comment comment = cs.findById(commentId);
		Assert.assertNull(comment);
	}
}
