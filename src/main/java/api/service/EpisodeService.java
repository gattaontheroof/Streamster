package api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.Episode;
import api.repository.EpisodeRepository;

@Service
public class EpisodeService {
	
	@Autowired
	private final EpisodeRepository episodeRepository;
	
	public EpisodeService(EpisodeRepository episodeRepository) {
	super();
	this.episodeRepository = episodeRepository;
	}
	
	public Optional<Episode> findEpisodesByShowTitle(String episodeTitle) {	
		return episodeRepository.findByEpisodeTitle( episodeTitle);
	}
	public Optional<?> findById(Integer episodeId) {
		return episodeRepository.findById(episodeId);
	}
	public Optional<Episode> findEpisodesByShowTitle1(String showId) {
		return episodeRepository.findEpisodesByShowTitle(showId);
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
