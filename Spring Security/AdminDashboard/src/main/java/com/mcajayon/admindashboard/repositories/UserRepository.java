package com.mcajayon.admindashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcajayon.admindashboard.models.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
	@Query("SELECT u FROM User u")
	List<User> findAllUsers();
	
	@Modifying
	@Query("DELETE User u WHERE u.id = ?1")
	void deleteUserById(Long id);
}
