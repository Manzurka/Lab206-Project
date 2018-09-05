package com.lab206.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.models.Badge;

@Repository
public interface BadgeRepository extends CrudRepository<Badge, Long>  {
	
	List<Badge> findAll();
	
	List<Badge> findBadgeByNameContaining(String query);

}
