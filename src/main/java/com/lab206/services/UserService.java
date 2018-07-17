package com.lab206.services;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lab206.models.Comment;
import com.lab206.models.User;
import com.lab206.repositories.RoleRepository;
import com.lab206.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	private RoleRepository ror;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository ur,
			RoleRepository ror,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.ur = ur;
		this.ror = ror;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(ror.findByName("ROLE_USER"));
		ur.save(user);
	}
	
	public void saveUserWithModRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(ror.findByName("ROLE_MOD"));
		ur.save(user);
	}
	
	// Updating a users role as a new Moderator
	public void updateUserWithModRole(User user) {
		user.setRoles(ror.findByName("ROLE_MOD"));
		ur.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(ror.findByName("ROLE_ADMIN"));
		ur.save(user);
	}
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	public User findById(Long id) {
		return ur.findById(id).get();
	}
	
	public void increasePoints(User user) {
		user.setPoints(user.getPoints() + 1);
		ur.save(user);
	}
  
	public void save(User user) {
		ur.save(user);
	}
	
	public void removeUser(User u) {
		ur.delete(u);
	}
	
	public List<User> findByName(String keyword){
		return ur.findByFirstNameContaining(keyword);	
	}
	
	public List<User> findByPoints(){
		return ur.findByOrderByPointsDesc();
	}
	
	public String getCommenterFirstName(Comment c) {
		return ur.findCommenterOfCommentFirstName(c);
	}
  
}
