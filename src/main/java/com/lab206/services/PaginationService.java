package com.lab206.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.lab206.models.Post;
import com.lab206.repositories.PaginationRepository;

public class PaginationService {
	
	@Autowired 
	PaginationRepository pr;
	
	private static final int PAGE_SIZE = 3;
	
	
	public Page<Post> ninjasPerPage(int pageNumber) {
		
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE);
        Page<Post> posts = pr.findAll(pageRequest);
        return pr.findAll(pageRequest);
    }

}
