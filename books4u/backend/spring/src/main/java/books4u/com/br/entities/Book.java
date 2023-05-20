package books4u.com.br.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_books")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBook;
	private Integer copyBook;
	private Long isbnBook;
	private String nameBook;
	private Boolean statusBook;
	
	@ManyToOne
	@JoinColumn(name = "tb_genre_idtb_genre")
	private Genre genre;
	
	@OneToOne
	@JoinColumn(name = "tb_publishing_company_id_publishing_company")
	private PublishingCompany publishingCompany;
	
	@ManyToOne
	@JoinColumn(name = "tb_authors_id_authors")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "tb_books_localization_id_books_localization")
	private BooksLocalization booksLocalization;
	
	public Book() {
	}

	public Book(Long idBook, Integer copyBook, Long isbnBook, String nameBook, Boolean statusBook) {
		super();
		this.idBook = idBook;
		this.copyBook = copyBook;
		this.isbnBook = isbnBook;
		this.nameBook = nameBook;
		this.statusBook = statusBook;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public Integer getCopyBook() {
		return copyBook;
	}

	public void setCopyBook(Integer copyBook) {
		this.copyBook = copyBook;
	}

	public Long getIsbnBook() {
		return isbnBook;
	}

	public void setIsbnBook(Long isbnBook) {
		this.isbnBook = isbnBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public Boolean getStatusBook() {
		return statusBook;
	}

	public void setStatusBook(Boolean statusBook) {
		this.statusBook = statusBook;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public BooksLocalization getBooksLocalization() {
		return booksLocalization;
	}

	public void setBooksLocalization(BooksLocalization booksLocalization) {
		this.booksLocalization = booksLocalization;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBook);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(idBook, other.idBook);
	}
}
