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
@Table(name = "tb_loans")
public class Loan implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoan;
	private Integer loanStartDate;
	private Integer loanEndDate;
	private Double loanPrice;
	
	@OneToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	public Loan() {
	}

	public Loan(Long idLoan, Integer loanStartDate, Integer loanEndDate, Double loanPrice) {
		super();
		this.idLoan = idLoan;
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
		this.loanPrice = loanPrice;
	}

	public Long getIdLoan() {
		return idLoan;
	}

	public void setIdLoan(Long idLoan) {
		this.idLoan = idLoan;
	}

	public Integer getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(Integer loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public Integer getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(Integer loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public Double getLoanPrice() {
		return loanPrice;
	}

	public void setLoanPrice(Double loanPrice) {
		this.loanPrice = loanPrice;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(idLoan, other.idLoan);
	}
}
