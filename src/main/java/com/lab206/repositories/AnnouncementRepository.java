package com.lab206.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Announcement;

public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
	
	List <Announcement> findAll();

}
