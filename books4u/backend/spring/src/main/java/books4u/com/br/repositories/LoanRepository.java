package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	@Query("SELECT obj FROM Loan obj "
			+ "WHERE obj.book.idBook = :bookId "
			+ "AND obj.student.idStudent = :studentId")
	Loan findLoanByBookAndStudent(Long bookId, Long studentId);
}
