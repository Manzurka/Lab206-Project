package com.lab206.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.lab206.models.Quicklink;
import com.lab206.models.Tag;
import com.lab206.repositories.QuicklinkRepository;

@Service
public class QuicklinkService {
	private final QuicklinkRepository qr;
	
	public QuicklinkService(QuicklinkRepository qr) {
		this.qr = qr;
	}
	
	public List<Quicklink> findAll(){
		return qr.findAll();
	}
	
	public List<Quicklink> findByTag(Tag tag){
		return qr.findByTags(tag);
	}
	
	public void saveQuicklink(Quicklink quicklink) {
		qr.save(quicklink);
	}
}
