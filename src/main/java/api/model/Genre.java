package api.model;


import jakarta.annotation.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Genre {


	@Id
	@Column(name = "genre_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genregen")		@SequenceGenerator(name = "genregen", sequenceName = "genre_id_seq", initialValue = 1, allocationSize = 1 )
	private int genre_id;
		
	@Column(name = "GENRENAME")
	@NotBlank
	@Size(min = 1, max = 20)
	private String genreName;
		
	@Column(name = "DESCRIPTION")
	@Nullable 
	private String description;

	public Genre() {
		super();
	
	}

	public Genre(int genre_id,
			String genreName,
			String description) {
		super();
		this.genre_id = genre_id;
		this.genreName = genreName;
		this.description = description;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
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
