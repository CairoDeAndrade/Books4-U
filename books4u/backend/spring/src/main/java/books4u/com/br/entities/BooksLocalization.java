package books4u.com.br.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_books_localization")
public class BooksLocalization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooksLocalization;
	private Integer bookcaseNumber;
	private Character shelf;
	
	public BooksLocalization() {
	}

	public BooksLocalization(Long idBooksLocalization, Integer bookcaseNumber, Character shelf) {
		super();
		this.idBooksLocalization = idBooksLocalization;
		this.bookcaseNumber = bookcaseNumber;
		this.shelf = shelf;
	}

	public Long getIdBooksLocalization() {
		return idBooksLocalization;
	}

	public void setIdBooksLocalization(Long idBooksLocalization) {
		this.idBooksLocalization = idBooksLocalization;
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
		return Objects.hash(idBooksLocalization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksLocalization other = (BooksLocalization) obj;
		return Objects.equals(idBooksLocalization, other.idBooksLocalization);
	}
}
