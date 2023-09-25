package com.api.controller;

import java.util.List;


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

import com.api.model.Genre;
import com.api.service.GenreService;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class GenreController {
		
	@Autowired
	private GenreService genreService;
	
	@GetMapping("/all-genres")
	public List<Genre> findAll() {
		return genreService.getAllGenres();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getGenreByid(@PathVariable int genreId) {
		return ResponseEntity.status(HttpStatus.OK).body(genreService.findByGenreId(genreId));
	}
	
	@GetMapping("/searchByGenre")
	public ResponseEntity<?> findByGenre(@PathVariable String genre){
		return ResponseEntity.status(HttpStatus.OK).body(genreService.findByGenreName(genre));
	}
	
	@PostMapping("/add-genre")
	public ResponseEntity<?> saveGenre(@RequestBody Genre genre){
		return new ResponseEntity<>(genreService.save(genre), HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/update-genre")
	public ResponseEntity<Boolean> updateGenre(@RequestBody Genre genre){
		return ResponseEntity.ok(genreService.updateGenre(genre));
	}
	
	//delete
	@DeleteMapping("/{genre_id}")
	public ResponseEntity<Void> deleteGenre(@PathVariable int genre_id){
		genreService.removeGenre(genre_id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.build();
	}
}
