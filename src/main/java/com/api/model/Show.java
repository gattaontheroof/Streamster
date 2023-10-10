package com.api.model;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Show")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Show {

	@Id
	@Column(name = "SHOW_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_gen")
	@SequenceGenerator(name = "show_gen", sequenceName = "show_id_seq", initialValue = 1000, allocationSize = 1)
	private Integer showId;

	@Column(name = "SHOW_TITLE")
	@NotBlank
	@Size(min = 1, max = 60, message = "Title must  be longer than 1 character and less than 60 characters")
	private String showTitle;

	@Enumerated(EnumType.STRING)
	@Column(name = "SHOW_TYPE")
	@NotBlank
	@Size(min = 1, max = 10, message = "Title must  be longer than 1 character and less than 10 characters")
	private ShowType showType;

	@Column(name = "SHOW_RELEASE_YEAR")
	@NotBlank
	@Size(max = 10)
	private String showReleaseYear;

	@Enumerated(EnumType.STRING)
	@Column(name = "CERTIFICATE")
	@NotBlank
	@Size(min = 1, max = 10, message = "Please choose Age Certificate")
	private Certificate certificate;

	@Column(name = "SHOW_SYNOPSIS", nullable = true)
	@Size(max = 300)
	private String showSynopsis;

	@Enumerated(EnumType.STRING)
	@Column(name = "LANGUAGE", nullable = true)
	@Size(max = 20)
	private Language language = Language.ENGLISH;

	@Column(name = "SHOW_DURATION", nullable = true)
	@Size(max = 10)
	private String showDuration;

	@Column(name = "SHOW_IMAGE", nullable = true)
	@Size(min = 5, max = 100)
	private String showImage;

	@Column(name = "SHOW_TRAILER", nullable = true)
	@Size(min = 5, max = 100)
	private String showTrailer;

	@Column(name = "SHOW_STREAM", nullable = true)
	@Size(min = 5, max = 100)
	private String showStream;

	// many-to-many relationship between Show and Genre
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "SHOW_GENRE", joinColumns = @JoinColumn(name = "SHOW_ID"), inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
	private List<Genre> genres = new ArrayList<>();

	// bidirectional relationship between Show and Episode
	@Column(name = "EPISODE", nullable = true)
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Episode> episodes = new ArrayList<>();

	public Show() {

	}

	public Show(Integer showId, String showTitle, ShowType showType, String showReleaseYear, Certificate certificate,
			Language language, String showDuration, String showImage
//			List<Genre> genres
	) {
		super();
		this.showId = showId;
		this.showTitle = showTitle;
		this.showType = showType;
		this.showReleaseYear = showReleaseYear;
		this.certificate = certificate;
		this.language = language;
		this.showDuration = showDuration;
		this.showImage = showImage;
		// this.genres = genres;
	}

	public Show(Integer showId, String showTitle, ShowType showType, String showReleaseYear, Certificate certificate,
			String showSynopsis, Language language, String showDuration, String showImage, String showTrailer,
			String showStream, List<Genre> genres) {
		super();
		this.showId = showId;
		this.showTitle = showTitle;
		this.showType = showType;
		this.showReleaseYear = showReleaseYear;
		this.certificate = certificate;
		this.showSynopsis = showSynopsis;
		this.language = language;
		this.showDuration = showDuration;
		this.showImage = showImage;
		this.showTrailer = showTrailer;
		this.showStream = showStream;
		this.genres = genres;
	}

	// testing constructor
	public Show(Integer showId, String showTitle, ShowType showType, String showReleaseYear, Certificate certificate) {
		super();
		this.showId = showId;
		this.showTitle = showTitle;
		this.showType = showType;
		this.showReleaseYear = showReleaseYear;
		this.certificate = certificate;
	}


	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public ShowType getShowType() {
		return showType;
	}

	public void setShowType(ShowType showType) {
		this.showType = showType;
	}

	public String getShowReleaseYear() {
		return showReleaseYear;
	}

	public void setShowReleaseYear(String showReleaseYear) {
		this.showReleaseYear = showReleaseYear;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public String getShowSynopsis() {
		return showSynopsis;
	}

	public void setShowSynopsis(String showSynopsis) {
		this.showSynopsis = showSynopsis;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getShowDuration() {
		return showDuration;
	}

	public void setShowDuration(String showDuration) {
		this.showDuration = showDuration;
	}

	public String getShowImage() {
		return showImage;
	}

	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}

	public String getShowTrailer() {
		return showTrailer;
	}

	public void setShowTrailer(String showTrailer) {
		this.showTrailer = showTrailer;
	}

	public String getShow_stream() {
		return showStream;
	}

	public void setShowStream(String showStream) {
		this.showStream = showStream;
	}

	public List<Genre> getGenres() {

		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public void assignGenre(Genre genre) {
		genres.add(genre);
	}

}
