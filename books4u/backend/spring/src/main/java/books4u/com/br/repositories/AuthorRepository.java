package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_authors "
			+ "WHERE author_name = :name "
			+ "LIMIT 1")
	Author findOneAuthorByName(String name);
}
