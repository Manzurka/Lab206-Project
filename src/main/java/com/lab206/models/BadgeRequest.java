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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "badge_request")
public class BadgeRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Boolean reviewed;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User requester;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="badge_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Badge requestedBadge;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date updatedAt;
	
	public BadgeRequest() {
		this.reviewed = false;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Boolean getReviewed() {
		return this.reviewed;
	}
	
	public void setReviewed(Boolean reviewed) {
		this.reviewed = reviewed;
	}
	
	public User getRequester() {
		return this.requester;
	}
	
	public void setRequester(User requester) {
		this.requester = requester;
	}
	
	public Badge getRequestedBadge() {
		return this.requestedBadge;
	}
	
	public void setRequestedBadge(Badge badge) {
		this.requestedBadge = badge;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}

}
