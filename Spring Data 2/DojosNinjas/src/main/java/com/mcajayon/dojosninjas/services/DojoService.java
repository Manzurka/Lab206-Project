package com.mcajayon.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcajayon.dojosninjas.models.Dojo;
import com.mcajayon.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRep;
	public DojoService(DojoRepository dojoRep) {
		this.dojoRep = dojoRep;
	}
	
	public void createDojo(Dojo dojo) {
		dojoRep.save(dojo);
	}
	
	public List<Dojo> allDojos() {
		return dojoRep.findAll();
	}
	
}
