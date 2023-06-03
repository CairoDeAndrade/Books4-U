package books4u.com.br.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<GenreDto> findAll() {
		List<Genre> entities = repository.findAll();
		return entities.stream().map(x -> new GenreDto(x)).collect(Collectors.toList());
	}
}
