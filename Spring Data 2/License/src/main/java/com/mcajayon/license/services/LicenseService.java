package com.mcajayon.license.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mcajayon.license.models.License;
import com.mcajayon.license.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private LicenseRepository licenseRep;
	public LicenseService(LicenseRepository licenseRep) {
		this.licenseRep = licenseRep;
	}
	
	public List<License> allLicense() {
		return licenseRep.findAll();
	}
	
	public void addLicense(License license) {
		licenseRep.save(license);
	}
}
