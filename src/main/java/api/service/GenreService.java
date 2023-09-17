package api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import api.model.Genre;
import api.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	public GenreService (GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}
	
	public List<Genre> getAllGenres() {
		List<Genre> genreList = new ArrayList<Genre>();
		genreRepository.findAll().forEach(genre -> genreList.add(genre));
		return genreList;
	}
	
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}
	
	
	public Optional<?> findByGenreId(Integer genreId) {
		return genreRepository.findById(genreId);
	}
	
	public Optional<?> findByGenreName(String genreName){
		return genreRepository.findByGenreName(genreName);
	}
	
	public Genre createGenre(Genre genre) {
		Optional<Genre> existingGenre = genreRepository.findByGenreName(genre.getGenreName());
		if (existingGenre == null) {
			return genreRepository.save(genre);
		}
		return null;
	}

	public boolean updateGenre(Genre genre) {
		if (genreRepository.existsById(genre.getGenreId())) {
			genreRepository.save(genre);
			return true;
		}
		return false;
	}
	
	public boolean removeGenre(Integer genreId) {
		if (genreRepository.existsById(genreId)) {
			genreRepository.deleteById(genreId);
			return true;
		}
		return false;
	}


}
