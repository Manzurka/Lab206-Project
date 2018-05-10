package com.mcajayon.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcajayon.lookify.models.Song;
import com.mcajayon.lookify.repositories.SongRepository;

@Service
public class SongService {

	private SongRepository songRep;
	public SongService(SongRepository songRep) {
		this.songRep = songRep;
	}
	
	public List<Song> allSongs() {
		return songRep.findAll();
	}
	
	public Song findById(Long id) {
		Optional<Song> song = songRep.findById(id);
		if (song.isPresent()) {
			return song.get();
		}
		return null;
	}
	
	public List<Song> searchByArtist(String search) {
		return songRep.findByArtist(search);
	}
	
	public List<Song> topRated() {
		return songRep.findTop10ByOrderByRatingDesc();
	}
	
	public void addSong(Song song) {
		songRep.save(song);
	}
	
	public void destroySong(Long id) {
		songRep.deleteById(id);
	}
}