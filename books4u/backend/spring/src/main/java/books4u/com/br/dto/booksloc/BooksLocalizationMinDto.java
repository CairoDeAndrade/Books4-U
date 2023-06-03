package books4u.com.br.dto.booksloc;

import java.io.Serializable;

import books4u.com.br.entities.BooksLocalization;

public class BooksLocalizationMinDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer bookcaseNumber;
	private Character shelf;
	
	public BooksLocalizationMinDto() {
	}

	public BooksLocalizationMinDto(Integer bookcaseNumber, Character shelf) {
		super();
		this.bookcaseNumber = bookcaseNumber;
		this.shelf = shelf;
	}
	
	public BooksLocalizationMinDto(BooksLocalization entity) {
		bookcaseNumber = entity.getBookcaseNumber();
		shelf = entity.getShelf();
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
