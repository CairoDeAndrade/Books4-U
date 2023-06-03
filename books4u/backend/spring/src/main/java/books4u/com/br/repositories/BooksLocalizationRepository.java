package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.BooksLocalization;

@Repository
public interface BooksLocalizationRepository extends JpaRepository<BooksLocalization, Long>{
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_books_localizations "
			+ "WHERE bookcase_number = :bookcaseNumber AND "
			+ "shelf = :shelf LIMIT 1")
	BooksLocalization findLocalization(Integer bookcaseNumber, Character shelf);
}
