package com.api.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "EPISODE")
public class Episode {

	@Id
	@Column(name = "EPISODE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episode_gen")
	@SequenceGenerator(name = "episode_gen", sequenceName = "episode_id_seq", initialValue = 1, allocationSize = 1)
	private Integer episodeId;

	@Column(name = "EPISODE_TITLE", nullable = false)
	@Size(min = 1, max = 100, message = "Title must  be longer than 1 character and less than 100 characters")
	private String episodeTitle;

	// bidirectional relationship between Show and Episode
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOW_ID")
	private Show show;

	@Column(name = "EPISODE_PLOT", nullable = true)
	@Size(max = 200)
	private String episodePlot;

	@Column(name = "SEASON_NO", nullable = false)
	@Min(value = 1, message = "Season number must be at least 1")
	@Max(value = 99, message = "Season number must be at most 99")
	private Integer seasonNo;

	@Column(name = "SEASON_RELEASE_YEAR", nullable = true)
	private Date seasonReleaseYear;

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
	@Size(min = 5, max = 200)
	private String episodeStream;

	public Episode() {

	}

	public Episode(Integer episodeId, 
			String episodeTitle, 
			String episodePlot, 
			Integer seasonNo,
			Date seasonReleaseYear, 
			String episodeDuration, 
			String episodeImage, 
			String episodeTrailer,
			String episodeStream) {
		super();
		this.episodeId = episodeId;
		this.episodeTitle = episodeTitle;
	
		this.episodePlot = episodePlot;
		this.seasonNo = seasonNo;
		this.seasonReleaseYear = seasonReleaseYear;
		this.episodeDuration = episodeDuration;
		this.episodeImage = episodeImage;
		this.episodeTrailer = episodeTrailer;
		this.episodeStream = episodeStream;
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

	public Date getSeasonReleaseYear() {
		return seasonReleaseYear;
	}

	public void setSeasonReleaseYear(Date seasonReleaseYear) {
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
