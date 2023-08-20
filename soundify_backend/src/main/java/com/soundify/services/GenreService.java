package com.soundify.services;

import java.util.List;
import java.util.Optional;

import com.soundify.dtos.genres.GenreResponseDTO;
import com.soundify.entities.Genre;
import com.soundify.entities.Song;

public interface GenreService {
	 Optional<Genre> findGenreByName(String genreName);
	 List<GenreResponseDTO>getAllGenre();
}
