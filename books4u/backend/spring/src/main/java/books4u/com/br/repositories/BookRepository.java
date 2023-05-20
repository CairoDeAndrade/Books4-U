package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query(nativeQuery = true, value = 
			"SELECT tb_books.isbn_book FROM tb_books "
			+ "WHERE isbn_book = :isbn "
			+ "LIMIT 1")
	Long findByIsbn(Long isbn);
}
