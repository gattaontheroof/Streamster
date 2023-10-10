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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Episode;
import com.api.model.Show;
import com.api.model.ShowType;
import com.api.service.EpisodeService;
import com.api.service.ShowService;

@RestController
@RequestMapping("/api/v1/series")
@CrossOrigin(origins = "http://localhost:3000")
public class EpisodeController {

	@Autowired
	private EpisodeService episodeService;


//not working in postman
	@GetMapping("/all-episodes")
	
//	("/?showType=SERIES/all-episodes")
	 	 		
	public List<Episode> getAllEpisodesByShowType(@RequestParam("showType") ShowType showType) {
		
	    return episodeService.findAllEpisodesByShowType(showType);
	}
	
	// get all episodes in a series by show id

	@GetMapping("/{show_id}/all-episodes")
	public ResponseEntity<?> getAllEpisodesByShowId(@PathVariable ("show_id")Integer showId){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(episodeService.findAllEpisodesByShowId(showId));	
	}

	// get all episodes in a series by show title


	@GetMapping("{show_title}/all-episodes")
	public ResponseEntity<?> getAllEpisodesByShowTitle(@PathVariable("show_title") String showTitle){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(episodeService.findAllEpisodesByShowTitle(showTitle));	
	}

	// get an episode in a series by season

	// get an episode by show title and episode number

	// http://localhost:8080/api/v1/series/show/{show_title}/episode/{episode_no}
	
//	@GetMapping("/show/{show_id}/episode/{episode_no}")
//	public ResponseEntity<?> EpisodeByShowTitleAndEpisodeNumber(
//	    @PathVariable("showTitle") String showTitle,
//	    @PathVariable("episodeNumber") Integer episodeNumber)
//	   // @RequestParam String showTitle) 
//	{
//	    try {
//	//  Retrieve episodes by showId and showTitle
//	    	Optional<?> episode = episodeService.findEpisodeByShowTitleAndEpisodeNumber(showTitle, episodeNumber);
//
//	        if (!episode.isEmpty()) {
//	            return new ResponseEntity<>(episode, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>("No episodes found for this show", HttpStatus.NOT_FOUND);
//	        }
//	    } catch (Exception ex) {
//	 
//	        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	}

//	@GetMapping("/show/{show_id}/episode/{episode_id}")
//	public ResponseEntity<?> getAllEpisodesByShowAndId
//	(@RequestParam String showTitle) {
//	    try {
//	        Optional<?> episodes = episodeService.getAllEpisodesByShowTitle(showTitle);
//	        if (!episodes.isEmpty()) {
//	            return new ResponseEntity<>(episodes, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>("No episodes found for this show", HttpStatus.NOT_FOUND);
//	        }
//	    } catch (Exception ex) {
//	        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	}

	@GetMapping("/{episode-id}")
	public ResponseEntity<?> getEpisodeById(@PathVariable int episodeId) {
		return ResponseEntity.status(HttpStatus.OK).body(episodeService.findById(episodeId));
	}

	@PostMapping("/add-episode")
	public ResponseEntity<Episode> saveEpisode(@RequestBody Episode episode) {
		return new ResponseEntity<>(episodeService.saveEpisode(episode), HttpStatus.CREATED);
	}

	@PutMapping("/{episode-id}/update-episode")
	public ResponseEntity<Episode> updateEpisode(@RequestBody Episode episode) {
		return ResponseEntity.ok(episodeService.updateEpisode(episode));
	}

	@DeleteMapping("/{episode_id}")
	public ResponseEntity<Void> deleteEpisode(@PathVariable Integer episodeId) {
		if (episodeService.deleteEpisode(episodeId)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
