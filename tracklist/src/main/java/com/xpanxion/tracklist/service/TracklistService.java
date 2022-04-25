package com.xpanxion.tracklist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.tracklist.model.Song;
import com.xpanxion.tracklist.repository.TracklistRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TracklistService {

	@Autowired
	TracklistRepository tracklistRepository;
	
	// POST 
	public Song createSong(Song song) {
		return tracklistRepository.save(song);
	}
	
	// GET all
	public List<Song> getSongs() {
		return tracklistRepository.findAll();
	}
	
	// GET by Id
	public Optional<Song> getSongById(Long id) {
		return tracklistRepository.findById(id);
	}
	
	// DELETE
	public void deleteSong(Long songId) {
		tracklistRepository.deleteById(songId);
	}
	
	// PUT
	public Song updateTracklist(Long songId, Song songDetails) {
		Song song = tracklistRepository.findById(songId).get();
		song.setName(songDetails.getName());
		song.setGenre(songDetails.getGenre());
		song.setArtist(songDetails.getArtist());
		song.setDurationInSeconds(songDetails.getDurationInSeconds());
		
		return tracklistRepository.save(song);
	}
	
	// PATCH
	public Song updateSong(Long songId, String newName) {
		Song song = tracklistRepository.getById(songId);
		song.setName(newName);
		
		return tracklistRepository.save(song);
	}
	
}
