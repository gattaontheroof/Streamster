package api.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity (name = "Show")
public class Show {
	
	@Id
	@Column(name = "SHOW_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_gen")
	@SequenceGenerator(name = "show_gen", sequenceName = "show_id_seq", initialValue = 1, allocationSize = 1)
	private int show_id;
	
	@Column(name = "TITLE")
	@NotBlank(message = "Title must not be null or blank")
	@Size(min = 1, max = 60, message = "Title must  be longer than 1 character and less than 60 characters")
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SHOWTYPE")
	@NotBlank(message = "Show type must not be null or blank")
	@Size(min = 1, max = 10, message = "Title must  be longer than 1 character and less than 10 characters")
	private ShowType showType;
	
	@Column(name = "RELEASE_YEAR")
	@Size(min = 1, max = 20, message = "Release year must  be longer than 1 character and less than 20 characters")
	private String release_year;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CERTIFICATE")
	@NotBlank(message = "Age certificate must not be null or blank")
	@Size(min = 1, max = 4, message = "age certificate year must  be longer than 1 character and less than 4 characters")
	private Certificate certificate;
	
	@Column(name = "DESCRIPTON")
	@Nullable 
	@Size(max = 150) 
	private String description;
	
	@Column(name = "PARENT_SHOW_ID")
	@Nullable 
	@Size(max = 6) 
	private int parent_show_id;
	
	@Column(name = "EPISODE_ID")
	@Nullable 
	@Size(max = 8) 
	
	private String episode_id;
	@Column(name = "EPISODE_TITLE")
	@Nullable 
	@Size(max = 8)
	
	private String episode_title;
	@Column(name = "EPISODE_PLOT")
	@Nullable 
	@Size(max = 150)
	
	private String episode_plot;
	@Column(name = "LANGUAGE")
	@Nullable 
	@Size(max = 20)
	
//	@Enumerated(EnumType.STRING)
	private String language;
	@Column(name = "SEASON")
	@Nullable 
	@Size(max = 4)
	private int season;
	
	@Column(name = "DURATION")
	@Nullable 
	@Size(max = 4)
	private String duration;
	
	@Column(name = "IMAGE")
	@NotBlank(message = "Image required")
	@Size(min = 5, max = 100)
	private String image;
	
	@Column(name = "TRAILER")
	@NotBlank(message = "Link required")
	@Size(min = 5, max = 100)
	private String trailer;
	
	@Column(name = "EPISODE_TRAILER")
	@Nullable 
	@Size(max = 150) 
	private String episode_trailer;
	
	@Column(name = "STREAM")
	@NotBlank(message = "Link required")
	@Size(min = 5, max = 100)
	private String stream;

	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "show_and_genre", joinColumns = @JoinColumn(name = "show_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres = new ArrayList<>();


	public Show() {
		super();
	
		
	}


	public Show(int show_id,
		String title,
		ShowType showType,
		String release_year,
		Certificate certificate,
		int parent_show_id, 
		String language, 
		List<Genre> genres) {
		
		super();
		this.show_id = show_id;
		this.title = title;
		this.showType = showType;
		this.release_year = release_year;
		this.certificate = certificate;
		this.parent_show_id = parent_show_id;
		this.language = language;
		this.genres = genres;
	}

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ShowType getShowType() {
		return showType;
	}

	public void setShowType(ShowType showType) {
		this.showType = showType;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParent_show_id() {
		return parent_show_id;
	}

	public void setParent_show_id(int parent_show_id) {
		this.parent_show_id = parent_show_id;
	}

	public String getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(String episode_id) {
		this.episode_id = episode_id;
	}

	public String getEpisode_title() {
		return episode_title;
	}

	public void setEpisode_title(String episode_title) {
		this.episode_title = episode_title;
	}

	public String getEpisode_plot() {
		return episode_plot;
	}

	public void setEpisode_plot(String episode_plot) {
		this.episode_plot = episode_plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getEpisode_trailer() {
		return episode_trailer;
	}

	public void setEpisode_trailer(String episode_trailer) {
		this.episode_trailer = episode_trailer;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	
}

