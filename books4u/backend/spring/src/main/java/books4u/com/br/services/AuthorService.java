package books4u.com.br.services;

import books4u.com.br.dto.author.AuthorMinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books4u.com.br.dto.author.AuthorDto;
import books4u.com.br.entities.Author;
import books4u.com.br.repositories.AuthorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;

	@Transactional
	public AuthorMinDto insert(AuthorMinDto dto) {
		Author entity = new Author();
		entity.setAuthorName(dto.getName());
		entity.setAuthorStatus(dto.getStatus());
		
		entity = repository.save(entity);
		return new AuthorMinDto(entity);
	}
}
