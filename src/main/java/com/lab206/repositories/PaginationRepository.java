package com.lab206.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lab206.models.Post;

public interface PaginationRepository extends PagingAndSortingRepository<Post, Long> {

}
