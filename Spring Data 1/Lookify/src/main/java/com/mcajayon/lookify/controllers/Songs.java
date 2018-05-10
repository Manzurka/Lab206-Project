package com.mcajayon.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcajayon.lookify.models.Song;
import com.mcajayon.lookify.services.SongService;

@Controller
public class Songs {
	
	private final SongService songService;
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "add.jsp";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Song song = songService.findById(id);
		model.addAttribute("song", song);
		return "details.jsp";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam(value="artist") String search, Model model) {
		List<Song> results = songService.searchByArtist(search);
		if (results.isEmpty()) {
			model.addAttribute("found", false);
			model.addAttribute("artist", search);
		} else {
			model.addAttribute("found", true);
			model.addAttribute("results", results);
			model.addAttribute("artist", search);
		}
		return "search.jsp";
	}
	
	@RequestMapping("/songs/topSongs")
	public String topSongs(Model model) {
		List<Song> results = songService.topRated();
		model.addAttribute("results", results);
		return "topsongs.jsp";
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songService.destroySong(id);
		return "redirect:/dashboard";
	}
}