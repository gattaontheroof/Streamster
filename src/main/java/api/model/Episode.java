package api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "Episode")
public class Episode extends Show {

	@Column(name = "EPISODE_ID", nullable = false)
	private Integer episodeId;

	@Column(name = "EPISODE_TITLE", nullable = false)
	private String episodeTitle;
	
	@Column(name = "SERIES_ID", nullable = false)
	private Integer seriesId;
	
	@Column(name = "EPISODE_PLOT", nullable = true)
	private String episodePlot;
	
	@Column(name = "SEASON_NO", nullable = false)
	@Size(max = 2)
	private Integer seasonNo;
	
	@Column(name = "SEASON_RELEASE_YEAR")
	@Size(max = 4)
	private String seasonReleaseYear;
	
	@Column(name = "EPISODE_DURATION", nullable = true) 
	@Size(max = 4)
	private String episodeDuration;
	
	@Column(name = "EPISODE_IMAGE", nullable = false)
	@Size(min = 5, max = 100)
	private String episodeImage;
	
	@Column(name = "EPISODE_TRAILER", nullable = false)
	@Size(max = 150) 
	private String episodeTrailer;
	
	@Column(name = "EPISODE_STREAM", nullable = false)
	@Size(min = 5, max = 100)
	private String episodeStream;
	

	public Episode() {
	
	}

	
	public Episode(Integer episodeId,
			String episodeTitle,
			Integer seriesId,
			String episodePlot, 
			Integer seasonNo,
			String seasonReleaseYear, 
			String episodeDuration,
			String episodeImage, 
			String episodeTrailer,
			String episodeStream) {
		super();
		this.episodeId = episodeId;
		this.episodeTitle = episodeTitle;
		this.seriesId = seriesId;
		this.episodePlot = episodePlot;
		this.seasonNo = seasonNo;
		this.seasonReleaseYear = seasonReleaseYear;
		this.episodeDuration = episodeDuration;
		this.episodeImage = episodeImage;
		this.episodeTrailer = episodeTrailer;
		this.episodeStream = episodeStream;
	}


	

	public Episode(Integer showId, String showTitle, ShowType showType, String showReleaseYear,
			Certificate certificate, Language language, String showDuration, String showImage, List<Genre> genres) {
		super(showId, showTitle, showType, showReleaseYear, certificate, language, showDuration, showImage, genres);

	}



	public Episode(Integer showId, String showTitle, ShowType showType, String showReleaseYear,
			Certificate certificate, String showSynopsis, Language language, String showDuration, String showImage,
			String showTrailer, String showStream, List<Genre> genres) {
		super(showId, showTitle, showType, showReleaseYear, certificate, showSynopsis, language, showDuration,
				showImage, showTrailer, showStream, genres);

	}



	public Integer getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Integer episodeId) {
		this.episodeId = episodeId;
	}

	public String getEpisodeTitle() {
		return episodeTitle;
	}
	

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public void setEpisodeTitle(String episodeTitle) {
		this.episodeTitle = episodeTitle;
	}

	public String getEpisodePlot() {
		return episodePlot;
	}


	public void setEpisodePlot(String episodePlot) {
		this.episodePlot = episodePlot;
	}


	public Integer getSeasonNo() {
		return seasonNo;
	}

	public void setSeasonNo(Integer seasonNo) {
		this.seasonNo = seasonNo;
	}


	public String getSeasonReleaseYear() {
		return seasonReleaseYear;
	}


	public void setSeasonReleaseYear(String seasonReleaseYear) {
		this.seasonReleaseYear = seasonReleaseYear;
	}


	public String getEpisodeDuration() {
		return episodeDuration;
	}


	public void setEpisodeDuration(String episodeDuration) {
		this.episodeDuration = episodeDuration;
	}


	public String getEpisodeImage() {
		return episodeImage;
	}

	public void setEpisodeImage(String episodeImage) {
		this.episodeImage = episodeImage;
	}

	public String getEpisodeTrailer() {
		return episodeTrailer;
	}

	public void setEpisodeTrailer(String episodeTrailer) {
		this.episodeTrailer = episodeTrailer;
	}

	public String getEpisodeStream() {
		return episodeStream;
	}

	public void setEpisodeStream(String episodeStream) {
		this.episodeStream = episodeStream;
	}


	
	
	
}
