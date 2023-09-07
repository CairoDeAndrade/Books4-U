package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.genre.GenreDto;
import books4u.com.br.dto.genre.GenreMinDto;
import books4u.com.br.entities.Genre;
import books4u.com.br.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repository;
	
	@Transactional
	public GenreMinDto insert(GenreMinDto dto) {
		Genre entity = new Genre();
		entity.setGenreName(dto.getName());
		entity = repository.save(entity);
		return new GenreMinDto(entity);
	}

	@Transactional(readOnly = true)
	public Page<GenreDto> findAllPaged(Pageable pageable) {
		Page<Genre> list = repository.findAll(pageable);
		return list.map(GenreDto::new);
	}
}
