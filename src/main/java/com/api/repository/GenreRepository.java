package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Genre;

public interface GenreRepository  extends JpaRepository<Genre, Integer>{
	

	Optional<Genre> findById(int genreId);
	Optional<Genre> findByGenreName(String genreName);

}
