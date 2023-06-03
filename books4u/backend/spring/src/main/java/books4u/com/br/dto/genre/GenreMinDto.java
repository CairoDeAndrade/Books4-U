package books4u.com.br.dto.genre;

import java.io.Serializable;

import books4u.com.br.entities.Genre;

public class GenreMinDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public GenreMinDto() {
	}

	public GenreMinDto(String name) {
		super();
		this.name = name;
	}
	
	public GenreMinDto(Genre entity) {
		name = entity.getGenreName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
