package com.soundify.daos;

import com.soundify.entities.Genre;
import com.soundify.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongDao extends JpaRepository<Song, Long> {
	List<Song> findByGenresGenreName(String genreName);

	List<Song> findByArtistNameContainingIgnoreCase(String artistName);

	List<Song> findByArtistFirstNameOrArtistLastName(String firstName, String lastName);

	List<Song> findByGenresContaining(Genre genre);

	List<Song> findBySongNameContainingIgnoreCase(String songName);
	
	
	
	

}
