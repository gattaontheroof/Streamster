package api.controller;


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

import api.model.Episode;
import api.service.EpisodeService;

@RestController
@RequestMapping("/api/v1/shows/episodes")
@CrossOrigin(origins = "http://localhost:3000")
public class EpisodeController {
	
	@Autowired
	private EpisodeService episodeService;
	
//	@GetMapping("/all-episodes")
//	public List<Show> findAllEpisodes(){
//		return episodeService.findAllEpisodes();

	@GetMapping("/searchEpisodesByShowTitle")
	public ResponseEntity<?> findEpisodesByShowTitle(@PathVariable String showId){
		return ResponseEntity.status(HttpStatus.OK).body(episodeService.findEpisodesByShowTitle(showId));	
	}
	
	@PostMapping("/add-episode")
	public ResponseEntity<Episode> saveEpisode(@RequestBody Episode episode) {
		return new ResponseEntity<> (episodeService.saveEpisode(episode), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-episode")
	public ResponseEntity<Episode> updateEpisode(@RequestBody Episode episode) {
		return ResponseEntity.ok(episodeService.updateEpisode(episode));
	}
	
	@DeleteMapping("/{episode_id}")
	public ResponseEntity<Void> deleteEpisode(@PathVariable Integer episodeId){
		if (episodeService.deleteEpisode(episodeId)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
