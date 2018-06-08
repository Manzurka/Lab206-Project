package com.lab206.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lab206.models.Role;
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
    
    public Role findRoleByName(String role) {
    	return roleRepository.findRoleByName(role);
    }
    
    public void save(User user) {
    	userRepository.save(user);
    }
    
//	Logger log = LoggerFactory.getLogger(this.getClass().getName());
//	private final Path rootLocation = Paths.get(System.getProperty("user.dir")+"/src/main/resources/static/images");
//
//	public void store(MultipartFile file){
//		try {
//            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
//            System.out.println(file);
//            System.out.println(rootLocation);
//        } catch (Exception e) {
//        	throw new RuntimeException("FAIL!");
//        }
//	}
//	
//	public Resource loadFile(String filename) {
//        try {
//            Path file = rootLocation.resolve(filename);
//            Resource resource = new UrlResource(file.toUri());
//            if(resource.exists() || resource.isReadable()) {
//                return resource;
//            }else{
//            	throw new RuntimeException("File not found!");
//            }
//        } catch (MalformedURLException e) {
//        	throw new RuntimeException("File not found!");
//        }
//    }
}
