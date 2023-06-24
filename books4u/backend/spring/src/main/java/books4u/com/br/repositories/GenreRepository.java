package books4u.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import books4u.com.br.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
	
	Genre findByGenreName(String genreName);
}
