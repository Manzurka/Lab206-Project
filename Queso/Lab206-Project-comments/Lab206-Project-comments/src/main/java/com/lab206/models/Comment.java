package com.lab206.models;

import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.lab206.models.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lab206.models.Post;

@Entity
@Table(name="comments")
@JsonIdentityInfo(
		  scope = Comment.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Comment {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column 
	@NotEmpty
	private String content;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User commenter;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Post post;
	
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="question_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Post question;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_likedComments", 
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<User> commentLikes;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_dislikedComments", 
            joinColumns = @JoinColumn(name = "comment_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<User> commentDislikes;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	public Comment() {
		
	}
	
	public Comment(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Post getQuestion() {
		return question;
	}

	public void setQuestion(Post question) {
		this.question = question;
	}

	public List<User> getCommentLikes() {
		return commentLikes;
	}

	public void setCommentLikes(List<User> commentLikes) {
		this.commentLikes = commentLikes;
	}

	public List<User> getCommentDislikes() {
		return commentDislikes;
	}

	public void setCommentDislikes(List<User> commentDislikes) {
		this.commentDislikes = commentDislikes;
	}
	
}
