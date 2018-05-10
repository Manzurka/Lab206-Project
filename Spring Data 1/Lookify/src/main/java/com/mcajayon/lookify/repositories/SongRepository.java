package com.mcajayon.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcajayon.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
	List<Song> findByArtist(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}