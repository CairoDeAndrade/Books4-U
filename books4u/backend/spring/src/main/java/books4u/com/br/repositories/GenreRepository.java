package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
	
	@Query(nativeQuery = true, value =
			"SELECT * FROM book_hml.tb_genres "
			+ "WHERE genre_name = :genreName LIMIT 1")
	Genre findOneGenreByName(String genreName);
}
