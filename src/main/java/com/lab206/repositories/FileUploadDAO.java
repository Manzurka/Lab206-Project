package com.lab206.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lab206.models.File;

@Repository
public interface FileUploadDAO extends JpaRepository<File, Long> {
	Optional<File> findById(Long id);
	@Transactional 
	@Modifying 
	@Query("delete from File f where f.id = :x")
	void delete(@Param("x") Long id);

}
