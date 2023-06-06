package books4u.com.br.dto.booksloc;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.entities.BooksLocalization;

public class BooksLocalizationDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer bookcaseNumber;
	private Character shelf;
	
	public BooksLocalizationDto() {
	}

	public BooksLocalizationDto(Long id, Integer bookcaseNumber, Character shelf) {
		super();
		this.bookcaseNumber = bookcaseNumber;
		this.shelf = shelf;
	}
	
	public BooksLocalizationDto(BooksLocalization entity) {
		id = entity.getIdBooksLocalization();
		bookcaseNumber = entity.getBookcaseNumber();
		shelf = entity.getShelf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBookcaseNumber() {
		return bookcaseNumber;
	}

	public void setBookcaseNumber(Integer bookcaseNumber) {
		this.bookcaseNumber = bookcaseNumber;
	}

	public Character getShelf() {
		return shelf;
	}

	public void setShelf(Character shelf) {
		this.shelf = shelf;
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
		BooksLocalizationDto other = (BooksLocalizationDto) obj;
		return Objects.equals(id, other.id);
	}
}
