package com.api.model;


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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "EPISODE")
public class Episode {

	@Id
	@Column(name = "EPISODE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episode_gen")
	@SequenceGenerator(name = "episode_gen", sequenceName = "episode_id_seq", initialValue = 1000, allocationSize = 1)
	private Integer episodeId;

		// bidirectional relationship between Show and Episode
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOW_ID")
	private Show show;
	
	@Column(name = "EPISODE_NO")
	@NotBlank
	@Size(min = 4, max = 10)
	private Integer episodeNumber;

	@Column(name = "EPISODE_TITLE")
	@NotBlank
	@Size(min = 1, max = 100, message = "Title must  be longer than 1 character and less than 100 characters")
	private String episodeTitle;

	@Column(name = "EPISODE_PLOT", nullable = true)
	@Size(max = 200)
	private String episodePlot;

	@Column(name = "NO_OF_SEASON", nullable = true)
	@Size(min = 1, max = 99)
	private Integer noOfSeasons;

	@Column(name = "SEASON_RELEASE_YEAR", nullable = true)
	private String seasonReleaseYear;

	@Column(name = "EPISODE_DURATION", nullable = true)
	@Size(max = 8)
	private String episodeDuration;

	@Column(name = "EPISODE_IMAGE", nullable = true)
	@Size(min = 5, max = 100)
	private String episodeImage;

	@Column(name = "EPISODE_TRAILER", nullable = true)
	@Size(max = 150)
	private String episodeTrailer;

	@Column(name = "EPISODE_STREAM")
	@NotBlank
	@Size(min = 5, max = 200)
	private String episodeStream;

	public Episode() {

	}

	public Episode(Integer episodeId, Integer episodeNumber, String episodeTitle, String episodePlot,
			Integer noOfSeasons, String seasonReleaseYear, String episodeDuration, String episodeImage,
			String episodeTrailer, String episodeStream) {
		super();
		this.episodeId = episodeId;
		this.episodeNumber = episodeNumber;
		this.episodeTitle = episodeTitle;
		this.episodePlot = episodePlot;
		this.noOfSeasons = noOfSeasons;
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

	public Integer getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Integer getNoOfSeasons() {
		return noOfSeasons;
	}

	public void setNoOfSeasons(Integer noOfSeasons) {
		this.noOfSeasons = noOfSeasons;
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
