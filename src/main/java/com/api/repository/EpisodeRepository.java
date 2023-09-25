package com.api.repository;

//import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Episode;


public interface EpisodeRepository extends JpaRepository <Episode, Integer>{

	Optional<?> findByShowShowTitle(String showTitle);

	Optional<?> findByShowShowId(Integer showId);

	boolean existsByShowShowTitle(String showTitle);

//	Optional<?> findEpisodeByEpisodeId(Integer episodeId);
	
	boolean existsById(Integer episodeId);

	




}
