package books4u.com.br.dto.book;

import java.io.Serializable;

public class BookIsbnDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long isbnBook;
	
	public BookIsbnDto() {
	}

	public BookIsbnDto(Long isbnBook) {
		super();
		this.isbnBook = isbnBook;
	}

	public Long getIsbnBook() {
		return isbnBook;
	}

	public void setIsbnBook(Long isbnBook) {
		this.isbnBook = isbnBook;
	}
}
