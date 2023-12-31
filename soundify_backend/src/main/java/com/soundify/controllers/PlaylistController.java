package com.soundify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soundify.dtos.ApiResponse;
import com.soundify.services.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "*")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> allPlaylistsByUser(@PathVariable Long userId) {

		return ResponseEntity.ok(playlistService.getAllplaylistsByUserId(userId));
	}

	@GetMapping("/songs/{playlistId}")
	public ResponseEntity<?> allSongsInPlaylist(@PathVariable Long playlistId) {

		return ResponseEntity.ok(playlistService.getAllSongsByPlaylistId(playlistId));
	}

	@PostMapping("/{playlistId}/song/{songId}")
	public ResponseEntity<?> addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
		playlistService.addSongToPlaylist(playlistId, songId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("success","Song Uploaded in Playlist"));
	}

	@DeleteMapping("/{playlistId}/song/{songId}")
	public ResponseEntity<?> removeSongFromPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
		playlistService.removeSongFromPlaylist(playlistId, songId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("success","Song Removed from Playlist"));
	}

	@PutMapping("/{playlistId}/")
	public ResponseEntity<?> updatePlaylistName(@PathVariable Long playlistId, @RequestBody String playlistName) {
		playlistService.updatePlaylistName(playlistId, playlistName);
		return ResponseEntity.ok(new ApiResponse("success","Playlist Name updated successfully!"));
	}

}
