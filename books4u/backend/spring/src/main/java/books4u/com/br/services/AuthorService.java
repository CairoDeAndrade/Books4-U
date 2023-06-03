package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books4u.com.br.dto.author.AuthorDto;
import books4u.com.br.entities.Author;
import books4u.com.br.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	public AuthorDto insert(AuthorDto dto) {
		Author entity = new Author();
		entity.setIdAuthor(dto.getId());
		entity.setAuthorName(dto.getName());
		entity.setAuthorStatus(dto.getStatus());
		
		entity = repository.save(entity);
		return new AuthorDto(entity);
	}
}
