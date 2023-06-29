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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "Show")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Show {
	
	@Id
	@Column(name = "SHOW_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_gen")
	@SequenceGenerator(name = "show_gen", sequenceName = "show_id_seq", initialValue = 1, allocationSize = 1)
	private Integer show_id;
	
	@Column(name = "SHOW_TITLE")
	@NotBlank(message = "Title must not be null or blank")
	@Size(min = 1, max = 60, message = "Title must  be longer than 1 character and less than 60 characters")
	private String show_title;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SHOW_TYPE")
	@NotBlank(message = "Show type must not be null or blank")
	@Size(min = 1, max = 10, message = "Title must  be longer than 1 character and less than 10 characters")
	private ShowType show_type;
	
	@Column(name = "SHOW_RELEASE_YEAR")
	@Size(max = 4)
	private String show_release_year;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CERTIFICATE")
	@NotBlank(message = "Age certificate must not be null or blank")
	@Size(min = 1, max = 4, message = "age certificate year must  be longer than 1 character and less than 4 characters")
	private Certificate certificate;
	
	@Column(name = "SHOW_SYNOPSIS")
	@Nullable 
	@Size(max = 150) 
	private String show_synopsis;

	@Enumerated(EnumType.STRING)
	@Column(name = "LANGUAGE")
	@Nullable 
	@Size(max = 20)
	private Language language;
	
	@Column(name = "SHOW_DURATION")
	@Nullable 
	@Size(max = 10)
	private String show_duration;
	
	@Column(name = "SHOW_IMAGE")
	@NotBlank(message = "Image required")
	@Size(min = 5, max = 100)
	private String show_image;
	
	@Column(name = "SHOW_TRAILER")
	@NotBlank(message = "Link required")
	@Size(min = 5, max = 100)
	private String show_trailer;
	
	@Column(name = "SHOW_STREAM")
	@NotBlank(message = "Link required")
	@Size(min = 5, max = 100)
	private String show_stream;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "show_and_genre", joinColumns = @JoinColumn(name = "show_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres = new ArrayList<>();
	

	public Show() {

	}

	
	public Show(Integer show_id,
			String show_title,
			ShowType show_type,
			String show_release_year,
			Certificate certificate,
			Language language,
			String show_duration,
			String show_image, 
			List<Genre> genres) {
		super();
		this.show_id = show_id;
		this.show_title = show_title;
		this.show_type = show_type;
		this.show_release_year = show_release_year;
		this.certificate = certificate;
		this.language = language;
		this.show_duration = show_duration;
		this.show_image = show_image;
		this.genres = genres;
	}



	public Show(Integer show_id,
			String show_title,
			ShowType show_type,
			String show_release_year,
			Certificate certificate,
			String show_synopsis,
			Language language,
			String show_duration,
			String show_image,
			String show_trailer,
			String show_stream, List<Genre> genres) {
		super();
		this.show_id = show_id;
		this.show_title = show_title;
		this.show_type = show_type;
		this.show_release_year = show_release_year;
		this.certificate = certificate;
		this.show_synopsis = show_synopsis;
		this.language = language;
		this.show_duration = show_duration;
		this.show_image = show_image;
		this.show_trailer = show_trailer;
		this.show_stream = show_stream;
		this.genres = genres;
	}

	public Integer getShow_id() {
		return show_id;
	}

	public void setShow_id(Integer show_id) {
		this.show_id = show_id;
	}

	public String getShow_title() {
		return show_title;
	}

	public void setShow_title(String show_title) {
		this.show_title = show_title;
	}

	public ShowType getShow_type() {
		return show_type;
	}

	public void setShow_type(ShowType show_type) {
		this.show_type = show_type;
	}

	public String getShow_release_year() {
		return show_release_year;
	}

	public void setShow_release_year(String show_release_year) {
		this.show_release_year = show_release_year;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public String getShow_synopsis() {
		return show_synopsis;
	}

	public void setShow_synopsis(String show_synopsis) {
		this.show_synopsis = show_synopsis;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getShow_duration() {
		return show_duration;
	}

	public void setShow_duration(String show_duration) {
		this.show_duration = show_duration;
	}

	public String getShow_image() {
		return show_image;
	}

	public void setShow_image(String show_image) {
		this.show_image = show_image;
	}

	public String getShow_trailer() {
		return show_trailer;
	}

	public void setShow_trailer(String show_trailer) {
		this.show_trailer = show_trailer;
	}

	public String getShow_stream() {
		return show_stream;
	}


	public void setShow_stream(String show_stream) {
		this.show_stream = show_stream;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	

	
}

