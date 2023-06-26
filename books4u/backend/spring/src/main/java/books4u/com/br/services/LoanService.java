package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.loan.LoanInsertDto;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.Loan;
import books4u.com.br.entities.Student;
import books4u.com.br.repositories.BookRepository;
import books4u.com.br.repositories.LoanRepository;
import books4u.com.br.repositories.StudentRepository;
import books4u.com.br.services.exceptions.LoanException;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Boolean insert(LoanInsertDto dto) {
		Book book = bookRepository.findNotBorrowedBookByIsbn(dto.getBookIsbn());
		if (book == null) {
			throw new LoanException("Este livro já está emprestado");
		}
		Student student = studentRepository.findByStudentEnrollment(dto.getStudentEnrollment());
		Loan loan = repository.findLoanByBookAndStudent(book.getIdBook(), student.getIdStudent());
		if (loan != null) {
			throw new LoanException("Este empréstimo está em andamento");
		}
		Loan newLoan = new Loan();
		copyInsertDtotoEntity(dto, newLoan);
		newLoan.setBook(book);
		newLoan.setStudent(student);
		newLoan = repository.save(newLoan);
		return true;
	}
	
	public static void copyInsertDtotoEntity(LoanInsertDto dto, Loan entity) {
		entity.setLoanStartDate(dto.getStartDate());
		entity.setLoanEndDate(dto.getEndDate());
		entity.setLoanPrice(dto.getPrice());
	}
}
