package com.mcajayon.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.mcajayon.dojosninjas.models.Ninja;
import com.mcajayon.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRep;
	public NinjaService(NinjaRepository ninjaRep) {
		this.ninjaRep = ninjaRep;
	}
	
	public void createNinja(Ninja ninja) {
		ninjaRep.save(ninja);
	}
}
