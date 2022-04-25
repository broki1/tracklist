package com.xpanxion.tracklist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.tracklist.model.Song;
import com.xpanxion.tracklist.service.TracklistService;

@RestController
@RequestMapping("/music")
public class TracklistController {
	
	@Autowired
	TracklistService tracklistService;
	
	@GetMapping("/tracks")
	public List<Song> readSongs() {
		return tracklistService.getSongs();
	}
	
	@PostMapping("/track")
	public Song createSong(@RequestBody Song song) {
		return tracklistService.createSong(song);
	}
	
	@GetMapping("/track/{songId}")
	public Optional<Song> readSong(@PathVariable(value = "songId") Long songId) {
		return tracklistService.getSongById(songId);
	}
	
	@PutMapping("/track/{songId}")
	public Song updateSong(@PathVariable(value = "songId") Long songId, @RequestBody Song song) {
		return tracklistService.updateTracklist(songId, song);
	}
	
	@PatchMapping("/track/{songId}/{newName}")
	public Song updateSongName(@PathVariable(value = "songId") Long songId, @PathVariable(value = "newName") String newName) {
		return tracklistService.updateSong(songId, newName);
	}
	
	@DeleteMapping("/track/{songId}")
	public void deleteSong(@PathVariable(value = "songId") Long songId) {
		tracklistService.deleteSong(songId);
	}

}
