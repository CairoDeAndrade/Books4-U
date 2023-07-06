package books4u.com.br.dto.loan;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.dto.book.BookMinDto;
import books4u.com.br.dto.student.StudentMinDto;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.Loan;
import books4u.com.br.entities.Student;

public class LoanMinDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer startDate;
	private Integer endDate;
	private Double price;
	
	private BookMinDto book;
	private StudentMinDto student;
	
	public LoanMinDto() {
	}

	public LoanMinDto(Long id, Integer startDate, Integer endDate, Double price) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	
	public LoanMinDto(Loan entity) {
		id = entity.getIdLoan();
		startDate = entity.getLoanStartDate();
		endDate = entity.getLoanEndDate();
		price = entity.getLoanPrice();
	}
	
	public LoanMinDto(Loan entity, Book book, Student student) {
		this(entity);
		this.book = new BookMinDto(book, book.getBooksLocalization());
		this.student = new StudentMinDto(student);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStartDate() {
		return startDate;
	}

	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	public Integer getEndDate() {
		return endDate;
	}

	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public BookMinDto getBook() {
		return book;
	}

	public void setBook(BookMinDto book) {
		this.book = book;
	}

	public StudentMinDto getStudent() {
		return student;
	}

	public void setStudent(StudentMinDto student) {
		this.student = student;
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
		LoanMinDto other = (LoanMinDto) obj;
		return Objects.equals(id, other.id);
	}
}
