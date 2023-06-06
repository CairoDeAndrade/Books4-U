package books4u.com.br.dto.author;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.entities.Author;

public class AuthorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Boolean status;
	
	public AuthorDto() {
	}

	public AuthorDto(Long id, String name, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public AuthorDto(Author entity) {
		id = entity.getIdAuthor();
		name = entity.getAuthorName();
		status = entity.getAuthorStatus();
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorDto other = (AuthorDto) obj;
		return Objects.equals(id, other.id);
	}
}
