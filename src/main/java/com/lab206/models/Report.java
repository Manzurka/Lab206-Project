package com.lab206.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "reports")
@JsonIdentityInfo(
		  scope = Report.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Report {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column
	//@Min(2)
	private String content;
	
	@Column
	private Boolean reviewed;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reported_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User reported;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reporter_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User reporter;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	public Report() {
		this.reviewed = false;
	}
	
	public Report(String content) {
		this.content = content;
		this.reviewed = false;
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

	public Boolean getReviewed() {
		return reviewed;
	}

	public void setReviewed(Boolean reviewed) {
		this.reviewed = reviewed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getReported() {
		return reported;
	}

	public void setReported(User reported) {
		this.reported = reported;
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}
	
}
