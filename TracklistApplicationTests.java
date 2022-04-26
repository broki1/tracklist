package com.xpanxion.tracklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xpanxion.tracklist.model.Song;
import com.xpanxion.tracklist.repository.TracklistRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TracklistApplicationTests {
	
	@Autowired
	TracklistRepository emp;
	
	
	@Test
	@Order(1)
	public void testCreate() {
		Song song = new Song();
		
		song.setId(10L);
		song.setName("House of Balloons");
		song.setArtist("The Weeknd");
		song.setGenre("Hip-Hop/R&B");
		song.setDurationInSeconds(300);
		
		emp.save(song);
		
		Long size = (long) (emp.findAll().size() - 1);
		
		assertNotNull(emp.findById(size).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<Song> list = emp.findAll();
		assertEquals(emp.findAll().size(), list.size());
	}

	
	@Test
	@Order(3)
	public void testSingleSong() {
		Song song = emp.findById(5L).get();
		assertEquals("House of Balloons", song.getName());
	}
	
	@Test
	@Order(4)
	public void testDelete() {
		assertFalse(emp.existsById(5L));
	}
}
