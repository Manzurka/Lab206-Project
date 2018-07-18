package com.lab206.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.models.Quicklink;
import com.lab206.models.Tag;

@Repository
public interface QuicklinkRepository extends CrudRepository <Quicklink, Long> {
	List <Quicklink> findAll();
	List <Quicklink> findByTags(Tag tag);
}