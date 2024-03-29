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
	private Integer bookCopy;
	private Long bookIsbn;
	private String bookName;
	private Boolean bookStatus;
	private Boolean bookBorrowed;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@OneToOne
	@JoinColumn(name = "publishing_company_id")
	private PublishingCompany publishingCompany;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "books_localization_id")
	private BooksLocalization booksLocalization;
	
	@OneToOne(mappedBy = "book")
	private Loan loan;
	
	public Book() {
	}

	public Book(Long idBook, Integer copyBook, Long isbnBook, String nameBook, Boolean statusBook, Boolean bookBorrowed) {
		super();
		this.idBook = idBook;
		this.bookCopy = copyBook;
		this.bookIsbn = isbnBook;
		this.bookName = nameBook;
		this.bookStatus = statusBook;
		this.bookBorrowed = bookBorrowed;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public Integer getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(Integer bookCopy) {
		this.bookCopy = bookCopy;
	}

	public Long getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(Long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Boolean getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Boolean bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Boolean getBookBorrowed() {
		return bookBorrowed;
	}

	public void setBookBorrowed(Boolean bookBorrowed) {
		this.bookBorrowed = bookBorrowed;
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

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
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
