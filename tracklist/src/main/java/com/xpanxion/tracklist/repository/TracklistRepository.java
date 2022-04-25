package com.xpanxion.tracklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xpanxion.tracklist.model.Song;

@Repository
public interface TracklistRepository extends JpaRepository<Song, Long> {
	
}
