package api.repository;

//import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Episode;


public interface EpisodeRepository extends JpaRepository <Episode, Integer>{

//	List<Episode> findEpisodesByShowTitle(String ShowId);

	Optional<Episode> findEpisodesByShowTitle(String showId);

	Optional<Episode> findByEpisodeTitle(String episodeTitle);



}
