package books4u.com.br.dto.genre;

import java.io.Serializable;

import books4u.com.br.entities.Genre;

public class GenreDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public GenreDto() {
	}

	public GenreDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public GenreDto(Genre entity) {
		id = entity.getIdGenre();
		name = entity.getGenreName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
