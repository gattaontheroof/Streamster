package api.model;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "Episode")
public class Episode extends Show {
//public class Episode{
//	@Id
	@Column(name = "EPISODE_ID" )
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episode_gen")
//	@SequenceGenerator(name = "episode_gen", sequenceName = "episode_id_seq", initialValue = 1, allocationSize = 1)
	private Integer episode_id;
	
//	@ManyToOne
//	@JoinColumn(name = "SHOW_ID")
//	private Integer show_id;
	
	@Column(name = "EPISODE_TITLE")
	@NotBlank(message = "Episode title must be provided")
	private String episode_title;
	
	@Column(name = "SERIES_ID")
	@NotBlank
	private Integer series_id;
	
	@Column(name = "EPISODE_PLOT")
	@Nullable 
	private String episode_plot;
	
	@Column(name = "SEASON_NO")
	@NotBlank
	@Size(max = 2)
	private Integer season_no;
	
	@Column(name = "SEASON_RELEASE_YEAR")
	@Size(max = 4)
	private String season_release_year;
	
	@Column(name = "EPISODE_DURATION")
	@Nullable 
	@Size(max = 4)
	private String episode_duration;
	
	@Column(name = "EPISODE_IMAGE")
	@Nullable 
	@Size(min = 5, max = 100)
	private String episode_image;
	
	@Column(name = "EPISODE_TRAILER")
	@Nullable 
	@Size(max = 150) 
	private String episode_trailer;
	
	@Column(name = "EPISODE_STREAM")
	@NotBlank(message = "Link required")
	@Size(min = 5, max = 100)
	private String episode_stream;
	
	

	public Episode() {
	
	}

	
	
	public Episode(Integer episode_id,
			String episode_title,
			Integer series_id,
			String episode_plot, 
			Integer season_no,
			String season_release_year, 
			String episode_duration,
			String episode_image, 
			String episode_trailer,
			String episode_stream) {
		super();
		this.episode_id = episode_id;
		this.episode_title = episode_title;
		this.series_id = series_id;
		this.episode_plot = episode_plot;
		this.season_no = season_no;
		this.season_release_year = season_release_year;
		this.episode_duration = episode_duration;
		this.episode_image = episode_image;
		this.episode_trailer = episode_trailer;
		this.episode_stream = episode_stream;
	}


	

	public Episode(Integer show_id, String show_title, ShowType show_type, String show_release_year,
			Certificate certificate, Language language, String show_duration, String show_image, List<Genre> genres) {
		super(show_id, show_title, show_type, show_release_year, certificate, language, show_duration, show_image, genres);
		// TODO Auto-generated constructor stub
	}



	public Episode(Integer show_id, String show_title, ShowType show_type, String show_release_year,
			Certificate certificate, String show_synopsis, Language language, String show_duration, String show_image,
			String show_trailer, String show_stream, List<Genre> genres) {
		super(show_id, show_title, show_type, show_release_year, certificate, show_synopsis, language, show_duration,
				show_image, show_trailer, show_stream, genres);
		// TODO Auto-generated constructor stub
	}



	public Integer getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(Integer episode_id) {
		this.episode_id = episode_id;
	}

	public String getEpisode_title() {
		return episode_title;
	}
	

	public Integer getSeries_id() {
		return series_id;
	}

	public void setSeries_id(Integer series_id) {
		this.series_id = series_id;
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


	public Integer getSeason_no() {
		return season_no;
	}

	public void setSeason_no(Integer season_no) {
		this.season_no = season_no;
	}


	public String getSeason_release_year() {
		return season_release_year;
	}


	public void setSeason_release_year(String season_release_year) {
		this.season_release_year = season_release_year;
	}


	public String getEpisode_duration() {
		return episode_duration;
	}


	public void setEpisode_duration(String episode_duration) {
		this.episode_duration = episode_duration;
	}


	public String getEpisode_image() {
		return episode_image;
	}

	public void setEpisode_image(String episode_image) {
		this.episode_image = episode_image;
	}

	public String getEpisode_trailer() {
		return episode_trailer;
	}

	public void setEpisode_trailer(String episode_trailer) {
		this.episode_trailer = episode_trailer;
	}

	public String getEpisode_stream() {
		return episode_stream;
	}

	public void setEpisode_stream(String episode_stream) {
		this.episode_stream = episode_stream;
	}


	
	
	
}
