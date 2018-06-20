package com.lab206.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.models.Report;
import com.lab206.repositories.ReportRepository;

@Service
public class ReportService {
	
	private final ReportRepository rr;
	
	
	public ReportService(ReportRepository rr) {
		this.rr = rr;
	}
	
	
	public List<Report> findAll() {
		return rr.findAll();
	}
	
	public Report findById(Long id) {
		return rr.findById(id).get();
	}

}