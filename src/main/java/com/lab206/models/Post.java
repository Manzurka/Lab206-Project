package com.lab206.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.lab206.models.User;
import com.lab206.models.Comment;

@Entity
@Table(name="posts")
public class Post {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column
	@NotEmpty
	private String title;
	
	@Column 
	@NotEmpty
	private String text;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date updatedAt;
	    
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
    @OneToOne(mappedBy="question", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Comment answer;
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_likedPosts", 
            joinColumns = @JoinColumn(name = "post_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> postLikes;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_dislikedPosts", 
            joinColumns = @JoinColumn(name = "post_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> postDislikes;
    
    
 // Tags
 	@ManyToMany(fetch = FetchType.LAZY)
 	@JoinTable(
 			name = "posts_tags",
 			joinColumns = @JoinColumn(name = "post_id"),
 			inverseJoinColumns = @JoinColumn(name = "tag_id")
 	)
 	private List<Tag> tags;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	public Post() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(List<User> postLikes) {
		this.postLikes = postLikes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment getAnswer() {
		return answer;
	}

	public void setAnswer(Comment answer) {
		this.answer = answer;
	}

	public List<User> getPostDislikes() {
		return postDislikes;
	}

	public void setPostDislikes(List<User> postDislikes) {
		this.postDislikes = postDislikes;
	}
	
	
}
