package com.lab206.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.models.Badge;

@Repository
public interface BadgeRepository extends CrudRepository<Badge, Long>  {

}
