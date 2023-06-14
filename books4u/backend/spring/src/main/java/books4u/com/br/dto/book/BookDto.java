package books4u.com.br.dto.book;

import java.util.Objects;

import books4u.com.br.dto.author.AuthorDto;
import books4u.com.br.dto.booksloc.BooksLocalizationDto;
import books4u.com.br.dto.genre.GenreDto;
import books4u.com.br.dto.publishing.PublishingCompanyDto;
import books4u.com.br.entities.Author;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.BooksLocalization;
import books4u.com.br.entities.Genre;
import books4u.com.br.entities.PublishingCompany;

public class BookDto {
	
	private Long id;
	private Integer copy;
	private Long isbn;
	private String name;
	private Boolean status;
	
	private GenreDto genre;
	private PublishingCompanyDto publishingCompany;
	private AuthorDto author;
	private BooksLocalizationDto localization;
	
	public BookDto() {
	}

	public BookDto(Long id, Integer copy, Long isbn, String name, Boolean status) {
		super();
		this.id = id;
		this.copy = copy;
		this.isbn = isbn;
		this.name = name;
		this.status = status;
	}
	
	public BookDto(Book entity) {
		id = entity.getIdBook();
		copy = entity.getBookCopy();
		isbn = entity.getBookIsbn();
		name = entity.getBookName();
		status = entity.getBookStatus();
	}
	
	public BookDto(Book entity, Genre genre, PublishingCompany publishingComp, 
			Author author, BooksLocalization localization) {
		this(entity);
		this.genre = new GenreDto(genre);
		this.publishingCompany = new PublishingCompanyDto(publishingComp);
		this.author = new AuthorDto(author);
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public GenreDto getGenre() {
		return genre;
	}

	public void setGenre(GenreDto genre) {
		this.genre = genre;
	}

	public PublishingCompanyDto getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(PublishingCompanyDto publishingComp) {
		this.publishingCompany = publishingComp;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
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
		BookDto other = (BookDto) obj;
		return Objects.equals(id, other.id);
	}
}
