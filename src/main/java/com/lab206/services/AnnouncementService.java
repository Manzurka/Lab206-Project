package com.lab206.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.lab206.models.Announcement;
import com.lab206.repositories.AnnouncementRepository;

@Service
public class AnnouncementService {
	
	private final AnnouncementRepository ar;
	
	public AnnouncementService(AnnouncementRepository ar) {
		this.ar = ar;
	}
	
	public List<Announcement> findAll() {
		return ar.findByOrderByIdDesc();
	}
	
	public Announcement findById(Long id) {
		return ar.findById(id).get();
	}
	
	
	// Creates the Announcement
	public void createAnnouncement(@Valid Announcement a) {
		ar.save(a);
		
	}
	
	// Archive Announcements
	public void removeAnnouncement(Announcement announce) {
		ar.delete(announce);
	}
	

}
