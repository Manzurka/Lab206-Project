package com.mcajayon.admindashboard.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min = 1, message = "cannot be empty")
	private String firstName;
	
	@Column
	@Size(min = 1, message = "cannot be empty")
	private String lastName;
	
	@Column
	private String username;
	
	@Column
	@Size(min = 10)
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date updatedAt;
	
	@Column
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date lastSignIn;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
	
	public User() {
		
	}
	
	public User(String fn,
			String ln,
			String email,
			String pwd,
			List<Role> roles) {
		this.firstName = fn;
		this.lastName = ln;
		this.username = email;
		this.password = pwd;
		this.roles = roles;
		this.lastSignIn = new Date();
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
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String email) {
		this.username = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public Date getLastSignIn() {
		return lastSignIn;
	}
	
	public void setLastSignIn(Date date) {
		this.lastSignIn = date;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}