package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
