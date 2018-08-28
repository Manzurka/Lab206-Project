package com.lab206.controllers;

import java.security.Principal;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.models.Announcement;
import com.lab206.models.User;
import com.lab206.models.Token;
import com.lab206.services.AnnouncementService;
import com.lab206.services.UserService;
import com.lab206.validator.UserValidator;

@Controller
public class AdminController {
	
	private final UserService us;
	private final AnnouncementService as;
	private final UserValidator userValidator;
	
	@Autowired
    private JavaMailSender sender;
	
	public AdminController(UserService us, UserValidator userValidator, AnnouncementService as) {
		this.us = us;
		this.userValidator = userValidator;
		this.as = as;

	}
	
	@RequestMapping("/admin")
    public String admin(Principal principal, Model model, @ModelAttribute("announce") Announcement announce) {
		model.addAttribute("all_users", us.findAll());
		model.addAttribute("all_announcements", as.findAll());
		
		String email = principal.getName();
		model.addAttribute("currentUser", us.findByEmail(email));
        return "admin.jsp";
    }
	
	@RequestMapping("/announce")
    public String announce(Principal principal, Model model, @ModelAttribute("announce") Announcement announce, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Nope, did not work");
			model.addAttribute("all_announcements", as.findAll());
			return "admin.jsp";
		}
		as.createAnnouncement(announce);
		model.addAttribute("all_announcements", as.findAll());
		System.out.println("WORKED");
        return "redirect:/admin";
    }
	
	
	@PostMapping("/invite")
    public String invite(HttpServletRequest request) {
		String email = request.getParameter("email");
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        // Creates a random string of nums and letters
        String SALTCHARS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        
        while (salt.length() < 16) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        
        try {
        	// Sends to the email address from the given parameter
            helper.setTo(email);
            helper.setSubject("This is your registration link");
            helper.setText("Thank You for joining Lab206. Please click the link to complete the full registration process -" + " http://localhost:8080/" + saltStr);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error while sending mail ..");
        }
        
        sender.send(message);
		return "redirect:/admin";
    }
	
	// Updating a Users role to Moderator or Admin 
	@RequestMapping("/newRole")
    public String newMod(HttpServletRequest request) {
		String newRoleEmailAddress = request.getParameter("newRoleEmailAddress");
		String newRole = request.getParameter("newRole");
		
		if (newRole.equals("Moderator")) {
			System.out.println("Mod");
			us.updateUserWithModRole(us.findByEmail(newRoleEmailAddress));
		}
		else if (newRole.equals("Admin")) {
			System.out.println("Admin");
			us.updateUserWithAdminRole(us.findByEmail(newRoleEmailAddress));
		}
		
		return "redirect:/admin";
    }
	
	// Deletes the selected user
	@RequestMapping("/user/{id}/delete")
	public String removeUser(@PathVariable("id") Long id, Principal p) {
		User user = us.findById(id);
		us.removeUser(user);
		return "redirect:/admin";				
	}
	

}
