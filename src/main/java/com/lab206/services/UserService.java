package com.lab206.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lab206.models.User;
import com.lab206.repositories.RoleRepository;
import com.lab206.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
    // For Login
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }
    
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
