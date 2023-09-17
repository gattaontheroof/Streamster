package api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.Show;
import api.model.ShowType;
import api.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private final ShowRepository showRepository;

	public ShowService(ShowRepository showRepository) {
		super();
		this.showRepository = showRepository;
	}
	
	public List<Show> findAllShows(){
		return showRepository.findAll();
	}
	
	public List<Show> getAllFilms(ShowType FILM){
		return showRepository.findByShowType(FILM);
	}
	
	
	public List<Show> getAllSeries(ShowType SERIES){
		return showRepository.findByShowType(SERIES);
	}
	
	
	public Optional<Show> findShowById(Integer showId){
		return showRepository.findById(showId);
	}
	
	public Optional<Show> findShowByTitle(String showTitle){
		return showRepository.findByShowTitle(showTitle);
	}
	
	public Show saveShow(Show show) {
		return showRepository.save(show);
	}
	public Show updateShow(Show show) {
		if(showRepository.existsById(show.getShowId())) {
			return showRepository.save(show);
		}
		return null;
	}
	public boolean deleteShow(Integer showId) {
		if (showRepository.existsById(showId)) {
			showRepository.deleteById(showId);
			return true;
		}
		return false;
	}

	
	//do enum mapping first?
	public List<Show> getShowByType(ShowType showType) {
		return showRepository.findByShowType(showType);
	}
}
