package com.mcajayon.events.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcajayon.events.models.Comment;
import com.mcajayon.events.models.Event;
import com.mcajayon.events.models.User;
import com.mcajayon.events.services.EventService;
import com.mcajayon.events.services.UserService;

@Controller
public class EventsController {
	private final EventService eventService;
	private final UserService userService;
	private String[] listOf50states;
	
	public EventsController(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
		this.listOf50states=new String[] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
	}
	
	@RequestMapping("/events") 
		public String dashboard(Principal principal, @ModelAttribute("event") Event event, Model m) {
		String email = principal.getName();
		User currentUser= userService.findByEmail(email);
	    String state = currentUser.getState();
		List<Event> instateevents = eventService.inStateEvents(state);
		List<Event> outofstate = eventService.outOfStateEvents(state);
		if ( instateevents == null) {
			m.addAttribute("inStatePage", 1);
		}
		if ( outofstate == null) {
			m.addAttribute("outOfStateEvents", 1);
		} else {
			m.addAttribute("inStateEvents", instateevents);
		}
		m.addAttribute("outOfStateEvents", outofstate);
		m.addAttribute("currentUser", currentUser);
		m.addAttribute("listOfstates", listOf50states);
		return "events.jsp";
	}

	@PostMapping("/addEvent") 
		public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Principal principal, Model model, HttpSession session){
		if (result.hasErrors()) {		
			System.out.println(event.getEventDate());
			User currentUser= userService.findByEmail(principal.getName());
	        model.addAttribute("currentUser", currentUser);
			String state = currentUser.getState();
			model.addAttribute("inStateEvents", eventService.inStateEvents(state));
			model.addAttribute("inStateEvents", eventService.outOfStateEvents(state));
			model.addAttribute("listOfstates", listOf50states);
			return "events.jsp";
		}
		Event e = eventService.saveEvent(event);
		User host = userService.findByEmail(principal.getName());
		eventService.setEventHost(host,e);
		return "redirect:/events";
	}

	@RequestMapping("/events/{id}")
		public String showEvent(@ModelAttribute("comment") Comment comment, @PathVariable("id") Long id, Model m){
		m.addAttribute("event", eventService.getById(id));
		return "showEvent.jsp";
	}
	
	@RequestMapping("/events/{id}/delete")
		public String addEvent(@PathVariable("id") Long id){
		eventService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
		public String editEvent(@ModelAttribute("event") Event event, @PathVariable("id") Long id, Principal principal, Model m){
		User currentUser = userService.findByEmail(principal.getName());
		m.addAttribute(currentUser);
		m.addAttribute("listOfstates", listOf50states);
		return "editEvent.jsp";
	}
	
	@PostMapping("/events/{id}/edit")
		public String updateEvent(Principal p,@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result){
		if (result.hasErrors()) {
			return "editEvent.jsp";
		}
		User host = userService.findByEmail(p.getName());
		eventService.updateEvent(event, host);
		return "redirect:/events";
	}
	
	@PostMapping("/events/{id}/addComment")
		public String  createComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, @PathVariable("id") Long id, Principal principal){
		if (result.hasErrors()) {
			return "redirect:/events/{id}";
		}
		Comment c = eventService.saveComment(comment);
		Event event = eventService.getById(id);
		eventService.linkCommentToEvent(c, event);
		String email = principal.getName();
		User commenter = userService.findByEmail(email);
		eventService.linkCommentToUser(c, commenter);
		return "redirect:/events/"+event.getId();
	}
	
	@RequestMapping("/events/{id}/addguest/{userid}")
		public String addGuest(@PathVariable("userid") Long userid, @PathVariable("id") Long id, Principal p){
		User guest = userService.findById(userid);
		Event event = eventService.getById(id);
		eventService.joinEventAsGuest(event,guest);
		return "redirect:/events";
	}
	
	@RequestMapping("/cancel/{userid}/{eventid}")
		public String cancel(@PathVariable("userid") Long userid, @PathVariable("eventid") Long eventid){
		User guest = userService.findById(userid);
		Event event = eventService.getById(eventid);
		eventService.cancel(event, guest);
		return "redirect:/events";
	}
}