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
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.lab206.models.Role;
import com.lab206.models.Post;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lab206.models.Comment;

@Entity
@Table(name="users")
@JsonIdentityInfo(
		  scope = User.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=2, max=64)
	private String firstName;
	
	@Column
	@Size(min=2, max=64)
	private String lastName;
	
	@Column
	@Pattern(regexp=".+@.+\\..+")
	private String email;
	
	@Column
	@Size(max=256)
	private String about;
	
	@Column
	private Integer points;
	
	@Column
	private String github;
	
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
	
    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Token token;
    
    @OneToOne(mappedBy="user4avatar", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private File file;

	@OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
        name = "user_likedComments", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<Comment> likedComments;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_badges", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private List<Badge> badges;
	
	@OneToMany(mappedBy = "quicklinkCreator", fetch = FetchType.LAZY)
	private List<Quicklink> quicklinks;
	
	@OneToMany(mappedBy = "projectCreator", fetch = FetchType.LAZY)
	private List<Project> projects;
	
	@OneToMany(mappedBy = "feedbackCreator", fetch = FetchType.LAZY)
	private List<Feedback> feedback;
	
	@OneToMany(mappedBy = "feedbackResolver", fetch = FetchType.LAZY)
	private List<Feedback> feedbackReviewed;
	
	@OneToMany(mappedBy = "reported", fetch = FetchType.LAZY)
	private List<Report> reportsAgainst;
	
	@OneToMany(mappedBy = "reporter", fetch = FetchType.LAZY)
	private List<Report> reportsFiled;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cohort_id")
	private Cohort cohort;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	public User() {
		this.points = 0;
	}
	
	public User(String firstName,
			String lastName,
			String email,
			String about,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.about = about;
		this.password = password;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
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
	
	public void addLikedPosts(Post post) {
		this.likedPosts.add(post);
	}
	
	public void removeLikedPost(Post post) {
		this.likedPosts.remove(post);
	}

	public List<Comment> getLikedComments() {
		return likedComments;
	}

	public void setLikedComments(List<Comment> likedComments) {
		this.likedComments = likedComments;
	}
	
	public void addLikedComment(Comment comment) {
		this.likedComments.add(comment);
	}
	
	public void removeLikedComment(Comment comment) {
		this.likedComments.remove(comment);
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public List<Quicklink> getQuicklinks() {
		return quicklinks;
	}

	public void setQuicklinks(List<Quicklink> quicklinks) {
		this.quicklinks = quicklinks;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public List<Feedback> getFeedbackReviewed() {
		return feedbackReviewed;
	}

	public void setFeedbackReviewed(List<Feedback> feedback) {
		this.feedbackReviewed = feedback;
	}

	public List<Report> getReportsAgainst() {
		return reportsAgainst;
	}

	public void setReportsAgainst(List<Report> reportsAgainst) {
		this.reportsAgainst = reportsAgainst;
	}

	public List<Report> getReportsFiled() {
		return reportsFiled;
	}

	public void setReportsFiled(List<Report> reportsFiled) {
		this.reportsFiled = reportsFiled;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

}
