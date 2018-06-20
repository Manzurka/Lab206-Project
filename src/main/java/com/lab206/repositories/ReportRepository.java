package com.lab206.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lab206.models.Report;

public interface ReportRepository extends CrudRepository<Report, Long> {
	
	List <Report> findAll();

}
