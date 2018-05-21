package com.mcajayon.admindashboard.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mcajayon.admindashboard.models.Role;
import com.mcajayon.admindashboard.models.User;
import com.mcajayon.admindashboard.repositories.RoleRepository;
import com.mcajayon.admindashboard.repositories.UserRepository;

@Service
public class UserService  implements ApplicationListener<AuthenticationSuccessEvent> {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository,
			RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	
	public Role findRoleByName(String name) {
		if (roleRepository.findByName(name).size() == 0) {
			return null;
		} else {
			return roleRepository.findByName(name).get(0);
		}
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user != null) {
			return user.get();
		}
		return null;
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void deleteUserById(Long id) {
		userRepository.deleteUserById(id);
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		UserDetails user = (UserDetails) event.getAuthentication().getPrincipal();
		User u = userRepository.findByUsername(user.getUsername());
		u.setLastSignIn(new Date());
		userRepository.save(u);
	}
}