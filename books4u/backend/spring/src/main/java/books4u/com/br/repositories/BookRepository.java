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
			+ "WHERE book_isbn = :isbn "
			+ "AND tb_books.book_borrowed = false LIMIT 1")
	Book findNotBorrowedBookByIsbn(Long isbn);
	
	List<Book> findByBookIsbn(Long isbn);
	
	@Query("SELECT obj FROM Book obj"
			+ " WHERE obj.bookName LIKE %:name%"
			+ " ORDER BY obj.bookCopy DESC")
	List<Book> findByBookName(String name);

	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_books "
			+ "ORDER BY id_book DESC LIMIT :amount")
	List<Book> findAllDynamic(Integer amount);	
}
