package com.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.api.exception.ResourceNotFoundException;
import com.api.model.Show;
import com.api.model.ShowType;
import com.api.service.ShowService;

@RestController
@RequestMapping("/api/v1/shows")
@CrossOrigin(origins = "http://localhost:3000")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@GetMapping("/all-shows")
	public List<Show> findAllShows(){
		return showService.findAllShows();	
	}
	
	@GetMapping("/all-films")
	public List<Show> getAllFilms(ShowType FILM){
		return showService.getAllFilms(FILM);	
	}
	
	@GetMapping("/all-series")
	public List<Show> getAllSeries(ShowType SERIES){
		return showService.getAllSeries(SERIES);	
	}
	
	@GetMapping("/shows/show/{show_id}")
	public ResponseEntity<?> getShowId(@PathVariable("show_id") Integer showId) {
		Optional<Show> show = showService.findShowById(showId);
	    if (show == null) {
	        throw new ResourceNotFoundException("Show with ID " + showId + " not found");
	    }
		return ResponseEntity.status(HttpStatus.OK).body(showService.findShowById(showId));
	}
	
	@GetMapping("/searchShowByTitle")
	public ResponseEntity<Optional<Show>> findByShowTitle(@PathVariable("showTitle") String showTitle){
		return ResponseEntity.status(HttpStatus.OK).body(showService.findShowByTitle(showTitle));		
	}
	
	@PostMapping("/add-show")
	public ResponseEntity<?> saveShow(@RequestBody Show show) {
		return new ResponseEntity<> (showService.saveShow(show), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-show")
	public ResponseEntity<Show> updateShow(@RequestBody Show show) {
		return ResponseEntity.ok(showService.updateShow(show));
	}
	
	@DeleteMapping("/{show_id}")
	public ResponseEntity<Void> deleteShow(@PathVariable Integer showId){
		if (showService.deleteShow(showId)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
