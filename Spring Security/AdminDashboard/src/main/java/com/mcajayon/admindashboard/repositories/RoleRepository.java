package com.mcajayon.admindashboard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.mcajayon.admindashboard.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	List<Role> findAll();
	List<Role> findByName(String name);
}
