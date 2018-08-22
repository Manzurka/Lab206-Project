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
	
	public void creatingReport(Report r) {
		rr.save(r);
	}
	
	public List<Report> findAll() {
		return rr.findByOrderByIdDesc();
	}
	
	public Report findReportById(Long id) {
		return rr.findById(id).get();
	}
	
	public void updateReportReview(Report report) {
		report.setReviewed(true);
		rr.save(report);
	}

}
