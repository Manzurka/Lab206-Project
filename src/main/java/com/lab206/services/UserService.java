package com.lab206.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(ror.findByName("ROLE_ADMIN"));
		ur.save(user);
	}
	
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	public void increasePoints(User user) {
		user.setPoints(user.getPoints() + 1);
		ur.save(user);
	}
	
}
