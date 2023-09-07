package books4u.com.br.dto.author;

import books4u.com.br.entities.Author;

import java.io.Serializable;
import java.util.Objects;

public class AuthorMinDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private Boolean status;

	public AuthorMinDto() {
	}

	public AuthorMinDto(Long id, String name, Boolean status) {
		super();
		this.name = name;
		this.status = status;
	}

	public AuthorMinDto(Author entity) {
		name = entity.getAuthorName();
		status = entity.getAuthorStatus();
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
}
