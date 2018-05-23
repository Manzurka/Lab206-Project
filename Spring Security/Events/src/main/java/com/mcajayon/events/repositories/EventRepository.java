package com.mcajayon.events.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mcajayon.events.models.Event;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event>findByState(String state);
	List<Event>findByStateNotIn(String state);
}