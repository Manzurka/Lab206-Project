package com.mcajayon.events.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column
	@Size(min=2, message="Event Name must be at least 2 characters")
	private String name;
	
	@Column 
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date eventDate;
	
	@Column
	@Size(min=2, message="Location must be at least 2 characters")
	private String location;
	
	@Column
	private String state;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MMMM/dd/yyyy")
	private Date createdAt;

	@Column
	@DateTimeFormat(pattern="MMMM/dd/yyyy")
	private Date updatedAt;
	
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY) 
	private List<Comment> comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events", 
            joinColumns = @JoinColumn(name = "event_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> guests;
	
	public Event() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getGuests() {
		return guests;
	}

	public void setGuests(List<User> guests) {
		this.guests = guests;
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