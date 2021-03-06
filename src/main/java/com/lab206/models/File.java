package com.lab206.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="files")
@JsonIdentityInfo(
		  scope = File.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class File {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
	private long id;
	
	@Column
    private String fileName;
    
    @Lob
    @Column
    private byte[] data;
    
    @Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user4avatar;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id")
	private Post post4file;
	
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="badge_id")
    private Badge badgefile;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Project project;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}

    
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Post getPost4file() {
		return post4file;
	}

	public void setPost4file(Post post4file) {
		this.post4file = post4file;
	}

	public User getUser4avatar() {
		return user4avatar;
	}

	public void setUser4avatar(User user4avatar) {
		this.user4avatar = user4avatar;
	}
	
	public Badge getBadgefile() {
		return badgefile;
	}

	public void setBadgefile(Badge badgefile) {
		this.badgefile = badgefile;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public Comment getFileCreator() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
