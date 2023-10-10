package com.api.repository;

import java.util.List;
//import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.model.Episode;
import com.api.model.ShowType;


public interface EpisodeRepository extends JpaRepository <Episode, Integer>{

	Optional<?> findByShowShowTitleIgnoreCase(String showTitle);

	Optional<?> findByShowShowId(Integer showId);

	boolean existsByShowShowTitle(String showTitle);
	
	boolean existsByShowShowId(Integer showId);
//repeated
//	Optional<?> findEpisodeByEpisodeId(Integer episodeId);
	
	boolean existsById(Integer episodeId);

//	Optional<?> findByShow_ShowIdAndShow_ShowTitle(Integer showId, String showTitle);

//	Optional<?> findByShow_ShowTitleAndEpisodeNumber(String showTitle, Integer episodeNumber);

//	boolean existsByShowTitleAndEpisodeNumber(String showTitle, Integer episodeNumber);


//	boolean findEpisodeByShowTitleAndNo(Integer showId, Integer episodeNumber);

	@Query("SELECT e FROM Episode e WHERE e.show.showTitle = :showTitle AND e.episodeNumber = :episodeNumber")
	Optional<Episode> findEpisodeByShowTitleAndEpisodeNumber(@Param("showTitle") String showTitle, @Param("episodeNumber") Integer episodeNumber);

	List<Episode> findAllByShow_ShowType(ShowType showType);







}
