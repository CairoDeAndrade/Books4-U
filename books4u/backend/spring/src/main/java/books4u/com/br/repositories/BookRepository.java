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
			+ "WHERE book_isbn = :isbn "
			+ "ORDER BY book_copy DESC LIMIT 1")
	Book findOneBookByIsbn(Long isbn);
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_books "
			+ "ORDER BY id_book DESC LIMIT :amount")
	List<Book> findAllDynamic(Integer amount);
	
	List<Book> findByBookIsbn(Long bookIsbn);
	
	@Query("SELECT b FROM Book b WHERE b.bookName "
			+ "LIKE %:name% ORDER BY b.bookCopy DESC")
	List<Book> findByBookName(String name);
}
