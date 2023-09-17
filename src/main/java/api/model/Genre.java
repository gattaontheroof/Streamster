package api.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Genre")
public class Genre {


	@Id
	@Column(name = "GENRE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genregen")		@SequenceGenerator(name = "genregen", sequenceName = "genre_id_seq", initialValue = 1, allocationSize = 1 )
	private Integer genreId;
		
	@Column(name = "GENRENAME", nullable = false)
	@Size(min = 1, max = 20)
	private String genreName;
		
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	public Genre() {
		super();
	
	}

	public Genre(Integer genreId,
			String genreName,
			String description) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
		this.description = description;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

		
}
