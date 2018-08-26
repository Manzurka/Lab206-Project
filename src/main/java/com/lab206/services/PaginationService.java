package com.lab206.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab206.models.Post;
import com.lab206.repositories.PaginationRepository;

@Service
@Transactional
public class PaginationService {
	
	@Autowired 
	PaginationRepository pr;
	
	private static final int PAGE_SIZE = 10;
	
	public Page<Post> postPerPage(int pageNumber) {
		
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.DESC, "createdAt");
        Page<Post> posts = pr.findAll(pageRequest);
        return pr.findAll(pageRequest);
    }

}
