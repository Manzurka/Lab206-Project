package com.mcajayon.events.repositories;

import org.springframework.stereotype.Repository;

import com.mcajayon.events.models.User;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByEmail(String email);
}