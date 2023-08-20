package com.soundify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soundify.dtos.ApiResponse;
import com.soundify.services.GenreService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	
	@Autowired
	GenreService genreService;
	
	
	//GENRE CRUD
	@GetMapping("/genre")
	 public ResponseEntity<?> getAllGenre(){
		 
		return ResponseEntity.ok(genreService.getAllGenre());
	 }
	
	@GetMapping("/genre/{genreId}")
	 public ResponseEntity<?> getGenreById(@PathVariable Long genreId){
		 
		return ResponseEntity.ok(genreService.getGenreById(genreId));
	 }
	
	@PostMapping("/genre")
	public ResponseEntity<?> addGenre(@RequestParam String genreName) {
		genreService.addGenre(genreName);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Genre Added Successfully"));
	}
	
	@PutMapping("/genre/{genreId}")
	public ResponseEntity<?> updateGenreName(@PathVariable Long genreId, @RequestParam String updatedGenreName) {
		genreService.updateGenreName(genreId,updatedGenreName);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("GenreName Updated Successfully"));
	}
	
	@DeleteMapping("/genre/{genreId}")
	public ResponseEntity<?> deleteGenre(@PathVariable Long genreId) {
		genreService.deleteGenre(genreId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Genre Deleted Successfully"));
	}
	
	@PutMapping("/genre/{genreId}/song/{songId}")
	public ResponseEntity<?> addSongToPlaylist(@PathVariable Long genreId, @PathVariable Long songId) {
		genreService.addSongToGenre(genreId, songId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Song Added To Genre"));
	}

	@DeleteMapping("/genre/{genreId}/song/{songId}")
	public ResponseEntity<?> removeSongFromPlaylist(@PathVariable Long genreId, @PathVariable Long songId) {
		genreService.removeSongFromGenre(genreId, songId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Song Removed from Genre"));
	}

}
