package com.lab206.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.lab206.models.Badge;
import com.lab206.repositories.BadgeRepository;
import com.lab206.repositories.BadgeRequestRepo;
import com.lab206.repositories.FileUploadDAO;

@Service
public class BadgeService {
	
	private final BadgeRepository br;
	private final FileUploadDAO fud;
	
	public BadgeService(BadgeRepository br, FileUploadDAO fud) {
		this.br = br;
		this.fud = fud;
	}
	
	// Saving the new Badge
	public void save(Badge badge) {		
		br.save(badge);
	}
	
	public List<Badge> findAll() {
		return br.findAll();
	}
	
	public Badge findById(Long id) {
		return br.findById(id).get();
	}
	
	public List<Badge> findBadgesContaining(String query) {
		return br.findBadgeByNameContaining(query);
	}
	

}
