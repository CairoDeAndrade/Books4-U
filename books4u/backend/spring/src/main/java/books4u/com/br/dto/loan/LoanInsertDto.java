package books4u.com.br.dto.loan;

import java.io.Serializable;
import java.util.Objects;

import books4u.com.br.entities.Loan;

public class LoanInsertDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer startDate;
	private Integer endDate;
	private Double price;
	
	private Long bookIsbn;
	private Long studentEnrollment;
	
	public LoanInsertDto() {
	}

	public LoanInsertDto(Long id, Integer startDate, Integer endDate, Double price) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	
	public LoanInsertDto(Loan entity) {
		id = entity.getIdLoan();
		startDate = entity.getLoanStartDate();
		endDate = entity.getLoanEndDate();
		price = entity.getLoanPrice();
		bookIsbn = entity.getBook().getBookIsbn();
		studentEnrollment = entity.getStudent().getStudentEnrollment();
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

	public Long getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(Long bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Long getStudentEnrollment() {
		return studentEnrollment;
	}

	public void setStudentEnrollment(Long studentEnrollment) {
		this.studentEnrollment = studentEnrollment;
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
		LoanInsertDto other = (LoanInsertDto) obj;
		return Objects.equals(id, other.id);
	}
}
