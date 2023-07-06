package books4u.com.br.dto.book;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.dto.booksloc.BooksLocalizationDto;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.BooksLocalization;

public class BookMinDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer copy;
	private Long isbn;
	private String name;
	
	private BooksLocalizationDto localization;
	
	public BookMinDto() {
	}

	public BookMinDto(Long id, Integer copy, Long isbn, String name, Boolean status, Boolean borrowed) {
		super();
		this.id = id;
		this.copy = copy;
		this.isbn = isbn;
		this.name = name;
	}
	
	public BookMinDto(Book entity) {
		id = entity.getIdBook();
		copy = entity.getBookCopy();
		isbn = entity.getBookIsbn();
		name = entity.getBookName();
	}
	
	public BookMinDto(Book entity, BooksLocalization localization) {
		this(entity);
		this.localization = new BooksLocalizationDto(localization);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCopy() {
		return copy;
	}

	public void setCopy(Integer copy) {
		this.copy = copy;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BooksLocalizationDto getLocalization() {
		return localization;
	}

	public void setLocalization(BooksLocalizationDto localization) {
		this.localization = localization;
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
		BookMinDto other = (BookMinDto) obj;
		return Objects.equals(id, other.id);
	}
}
