package com.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.exception.EpisodeNotFoundException;
import com.api.model.Episode;
import com.api.repository.EpisodeRepository;

@Service
public class EpisodeService {

	@Autowired
	private final EpisodeRepository episodeRepository;

	public EpisodeService(EpisodeRepository episodeRepository) {
		super();
		this.episodeRepository = episodeRepository;
	}

	
	 public Optional<?> getAllEpisodesByShowTitle(String showTitle) {
		 if (episodeRepository.existsByShowShowTitle(showTitle)) {
	        return episodeRepository.findByShowShowTitle(showTitle);
	    }
		 throw new EpisodeNotFoundException("No episodes found for this show");
	 }
	public Optional<?> findById(Integer episodeId) {
		if (episodeRepository.existsById(episodeId)) {
		return episodeRepository.findById(episodeId);
		}
		throw new EpisodeNotFoundException("Episode with ID : " + episodeId + " not found");
		
	}

	public Optional<?> findByShowShowId(Integer showId) {
		if (episodeRepository.existsById(showId)) {
			return episodeRepository.findByShowShowId(showId);
		}
		throw new EpisodeNotFoundException("No episode found");

	}

	public Optional<?> findEpisodeByEpisodeId(Integer episodeId) {
		if (episodeRepository.existsById(episodeId)) {
			return ((EpisodeService) episodeRepository).findEpisodeByEpisodeId(episodeId);
		}
		throw new EpisodeNotFoundException("No episode found");

	}

	public Episode saveEpisode(Episode episode) {
		return episodeRepository.save(episode);
	}

	public Episode updateEpisode(Episode episode) {
		if (episodeRepository.existsById(episode.getEpisodeId())) {
			return episodeRepository.save(episode);
		}
		return null;
	}

	public boolean deleteEpisode(Integer episodeId) {
		if (episodeRepository.existsById(episodeId)) {
			episodeRepository.deleteById(episodeId);
			return true;
		}
		return false;
	}

}
