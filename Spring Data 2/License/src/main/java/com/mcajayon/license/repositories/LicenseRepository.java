package com.mcajayon.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcajayon.license.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

	List<License> findAll();
}
