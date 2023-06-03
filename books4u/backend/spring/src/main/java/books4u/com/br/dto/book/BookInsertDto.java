package books4u.com.br.dto.book;

import java.io.Serializable;

public class BookInsertDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer bookCopy;
	private Long bookIsbn;
	private String bookName;
	private Boolean bookStatus;
	
	private String genreName;
	private String publishingCompanyName;
	private String authorName;
	private Integer bookcaseNumber;
	private Character shelf;

	public BookInsertDto() {
	}

	public BookInsertDto(Integer bookCopy, Long bookIsbn, String bookName, Boolean bookStatus, String genreName,
			String publishingCompanyName, String authorName, Integer bookcaseNumber, Character shelf) {
		super();
		this.bookCopy = bookCopy;
		this.bookIsbn = bookIsbn;
		this.bookName = bookName;
		this.bookStatus = bookStatus;
		this.genreName = genreName;
		this.publishingCompanyName = publishingCompanyName;
		this.authorName = authorName;
		this.bookcaseNumber = bookcaseNumber;
		this.shelf = shelf;
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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getPublishingCompanyName() {
		return publishingCompanyName;
	}

	public void setPublishingCompanyName(String publishingCompanyName) {
		this.publishingCompanyName = publishingCompanyName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
}
