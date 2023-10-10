package com.api.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.model.Certificate;
import com.api.model.Show;
import com.api.model.ShowType;
import com.api.repository.ShowRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ShowServiceTest {
	
	@Autowired
	private ShowService showService;
	private MockMvc mockMvc;
	
	@MockBean
	private ShowRepository showRepository;
	
	@Test
	public void testFindAllShows_ReturnsAListOfAllShows() {
		//Arrange
		Show mockShow1 = new Show(1001, "Show1Title1", ShowType.FILM, "2020", Certificate.VALUE_4);
		Show mockShow2 = new Show(1002, "ShowTitle2", ShowType.FILM, "2018", Certificate.VALUE_3);
		Show mockShow3 = new Show (1003, "Goldilocks3", ShowType.FILM, "2019",Certificate.VALUE_2);
		
		List<Show> mockShows = Arrays.asList(mockShow1, mockShow2, mockShow3);
		
		when(showRepository.findAll()).thenReturn(mockShows);
		
		//Act
		List<Show> shows = showService.findAllShows();
	
		//Assert
		assertIterableEquals(shows, mockShows);
	};

//	@Test
//	
//	public void testFindAllShows_ReturnsAnErrorMessage_IfListEmpty() {
//		//Act
//				List<Show> shows = showService.findAllShows();
//				
//		//Assert
//				
//				mockMvc.perform(get("/api/v1/shows/all-shows"))
//		           .andExpect(status().isNotFound()) // Expecting a 404 status code
//		           .andExpect(content().string("No shows found")); // Expecting an error message in the response body
//}
}
