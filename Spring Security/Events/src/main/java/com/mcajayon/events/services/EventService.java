package com.mcajayon.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcajayon.events.models.Comment;
import com.mcajayon.events.models.Event;
import com.mcajayon.events.models.User;
import com.mcajayon.events.repositories.CommentRepository;
import com.mcajayon.events.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;
	private final CommentRepository commentRepository;
	
	public EventService(EventRepository eventRepository, CommentRepository commentRepository) {
		this.eventRepository = eventRepository;
		this.commentRepository = commentRepository;
	}
	
	public Event getById(Long id) {
		return eventRepository.findById(id).get();
	}
	
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public List<Event> inStateEvents(String state) {
		return eventRepository.findByState(state);
	}
	
	public List<Event> outOfStateEvents(String state) {
		return eventRepository.findByStateNotIn(state);
	}
	
	public void setEventHost(User host, Event event) {
	    event.setHost(host);
	    eventRepository.save(event);
	}
	
	public void deleteEvent(Long id) {
		commentRepository.deleteById(id);
	}
	
	public void updateEvent(Event event, User host) {
		event.setHost(host);
		commentRepository.save(event);
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);	
	}
	
	public void linkCommentToEvent(Comment comment, Event event) {
		comment.setEvent(event);
		commentRepository.save(comment);
	}
	
	public void linkCommentToUser(Comment comment, User commenter) {
		comment.setCommenter(commenter);
		commentRepository.save(comment);
	}
	
	public void joinEventAsGuest(Event event, User guest) {
    	List<User> guests = event.getGuests();
    	guests.add(guest);
    	event.setGuests(guests);
    	eventRepository.save(event);
    }
	
	public void cancel(Event event, User guest) {
		List<User> guests = event.getGuests();
    	guests.remove(guest);
    	event.setGuests(guests);
    	eventRepository.save(event);
	}
}