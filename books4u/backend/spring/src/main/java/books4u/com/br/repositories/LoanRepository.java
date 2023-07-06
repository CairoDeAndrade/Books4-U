package books4u.com.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Loan;
import books4u.com.br.projections.LoanProjection;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	@Query("SELECT obj FROM Loan obj "
			+ "WHERE obj.book.idBook = :bookId "
			+ "AND obj.student.idStudent = :studentId")
	Loan findLoanByBookAndStudent(Long bookId, Long studentId);
	
	@Query(nativeQuery = true, value = 
			"SELECT loans.id_loan AS idLoan, loans.loan_start_date AS loanStartDate, loans.loan_end_date AS loanEndDate, loans.loan_price AS loanPrice, "
			+ "books.book_copy AS bookCopy, books.book_isbn AS bookIsbn, books.book_name AS bookName, "
			+ "localizaion.bookcase_number AS bookcaseNumber, localizaion.shelf AS shelf, "
			+ "students.student_fullname AS studentFullname, students.student_enrollment AS studentEnrollment, classrooms.classroom_year AS classroomYear "			
			+ "FROM tb_loans loans INNER JOIN tb_books books ON loans.book_id = books.id_book "
			+ "INNER JOIN tb_books_localizations localizaion ON localizaion.id_books_localization = books.books_localization_id "
			+ "INNER JOIN tb_students students ON students.id_student = loans.student_id "
			+ "INNER JOIN tb_classrooms classrooms ON classrooms.id_classroom = students.classroom_id")
	List<LoanProjection> findAllLoansWithBookAndStudent();
}
