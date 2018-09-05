package com.lab206.services;

import org.springframework.stereotype.Service;

import com.lab206.models.Badge;
import com.lab206.models.BadgeRequest;
import com.lab206.models.User;
import com.lab206.repositories.BadgeRequestRepo;

@Service
public class BadgeRequestService {
	
	private BadgeRequestRepo brr;
	private BadgeService bs;
	private UserService us;
	
	public BadgeRequestService(BadgeRequestRepo brr,
			BadgeService bs,
			UserService us) {
		this.brr = brr;
		this.bs = bs;
		this.us = us;
	}
	
	public void saveBadgeRequest(BadgeRequest badgeRequest,
			User user, 
			Badge badge) {
		badgeRequest.setRequester(user);
		badgeRequest.setRequestedBadge(badge);
		brr.save(badgeRequest);
	}
	
	public BadgeRequest findByUserAndBadge(User user,
			Badge badge) {
		BadgeRequest request = brr.findBadgeRequestByUserAndBadge(user, badge);
		if (request != null) {
			return request;
		} else {
			return null;
		}
	}

}
