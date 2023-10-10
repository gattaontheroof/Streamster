package com.api.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.model.Episode;
import com.api.repository.EpisodeRepository;

public class EpisodeControllerTest {
	
	@MockBean
	EpisodeRepository episodeRepository;

//	@Autowired
//	private EpisodeController episodeController;
//
//	@Test
//	public void testGetAllEpisodesByShowTitle() {
		
//		// arrange
//		String showTitle = "Homeland";
//		
//		
//		//act
//		//assert
//		when(episodeRepository.existsByShowShowTitle(showTitle.thenReturn(true));
//		
//        Episode sampleEpisode = new Episode();
//        
//     // Mock the behavior of episodeRepository to return the sample episode
//        when(episodeRepository.findByShowShowTitle(showTitle)).thenReturn(Optional.of(sampleEpisode));
//
//        // Call the controller method
//        Optional<?> result = episodeController.getAllEpisodesByShowAndId(showTitle);
//
//        // Assertions
//        assertTrue(result.isPresent()); // Check if the result is present
//        assertSame(sampleEpisode, result.get()); // Check if the returned episode is the same as the sample episode
//    }
//}
