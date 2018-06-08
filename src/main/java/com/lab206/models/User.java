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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.lab206.models.Role;
import com.lab206.models.Post;
import com.lab206.models.Comment;

@Entity
@Table(name="users")
public class User implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=2)
	private String firstName;
	
	@Column
	@Size(min=2)
	private String lastName;
	
	@Column
	@Pattern(regexp=".+@.+\\..+")
	private String email;
	
	@Column
	private Integer points;
	
	@Column
	private String image;
	
	@Column
	@Size(min=8)
    private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

	@OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
	private List<Post> post;
	
	@OneToMany(mappedBy="commenter", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_likedPosts", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> likedPosts;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_dislikedPosts", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> dislikedPosts;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_likedComments", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<Comment> likedComments;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_dislikedComments", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<Comment> dislikedComments;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getLikedPosts() {
		return likedPosts;
	}

	public void setLikedPosts(List<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}

	public List<Post> getDislikedPosts() {
		return dislikedPosts;
	}

	public void setDislikedPosts(List<Post> dislikedPosts) {
		this.dislikedPosts = dislikedPosts;
	}

	public List<Comment> getLikedComments() {
		return likedComments;
	}

	public void setLikedComments(List<Comment> likedComments) {
		this.likedComments = likedComments;
	}

	public List<Comment> getDislikedComments() {
		return dislikedComments;
	}

	public void setDislikedComments(List<Comment> dislikedComments) {
		this.dislikedComments = dislikedComments;
	}



}
