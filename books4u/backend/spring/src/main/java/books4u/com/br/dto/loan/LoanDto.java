package books4u.com.br.dto.loan;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.dto.book.BookDto;
import books4u.com.br.dto.student.StudentDto;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.Loan;
import books4u.com.br.entities.Student;

public class LoanDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer startDate;
	private Integer endDate;
	private Double price;
	
	private BookDto book;
	private StudentDto student;
	
	public LoanDto() {
	}

	public LoanDto(Long id, Integer startDate, Integer endDate, Double price) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	
	public LoanDto(Loan entity) {
		id = entity.getIdLoan();
		startDate = entity.getLoanStartDate();
		endDate = entity.getLoanEndDate();
		price = entity.getLoanPrice();
	}
	
	public LoanDto(Loan entity, Book book, Student student) {
		this(entity);
		this.book = new BookDto(book);
		this.student = new StudentDto(student);
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

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
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
		LoanDto other = (LoanDto) obj;
		return Objects.equals(id, other.id);
	}
}
