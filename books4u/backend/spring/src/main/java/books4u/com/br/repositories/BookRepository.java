package books4u.com.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_books "
			+ "WHERE book_isbn = :bookIsbn "
			+ "ORDER BY book_copy DESC LIMIT 1")
	Book findOneBookByIsbn(Long bookIsbn);
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_books "
			+ "ORDER BY book_name ASC LIMIT :amount")
	List<Book> findAllDynamic(Integer amount);
}
