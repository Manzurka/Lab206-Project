package com.lab206.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Badge;
import com.lab206.models.BadgeRequest;
import com.lab206.models.User;

public interface BadgeRequestRepo extends CrudRepository<BadgeRequest, Long>{

	List<BadgeRequest> findAll();
	
	@Query("SELECT b FROM BadgeRequest b WHERE b.reviewed IS false")
	List<BadgeRequest> findAllUnapproved();
	
	@Query("SELECT b from BadgeRequest b WHERE b.requester IS ?1 AND b.requestedBadge IS ?2 AND b.reviewed IS false")
	BadgeRequest findBadgeRequestByUserAndBadge(User user, Badge badge);
}
