package com.lab206.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cohorts")
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer cohortNumber;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createdAt;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date updatedAt;
    
    @OneToMany(mappedBy = "cohort", fetch = FetchType.LAZY)
	private List<User> students;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
    
    public Cohort() {
    	
    }
    
    public Cohort(Integer cohortNumber) {
    	this.cohortNumber = cohortNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCohortNumber() {
        return cohortNumber;
    }

    public void setCohortNumber(Integer cohortNumber) {
        this.cohortNumber = cohortNumber;
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

}
