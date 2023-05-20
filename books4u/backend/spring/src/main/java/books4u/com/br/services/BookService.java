package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.book.BookIsbnDto;
import books4u.com.br.dto.book.ExistsIsbnDto;
import books4u.com.br.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Transactional
	public ExistsIsbnDto existsIsbn(BookIsbnDto isbn) {
		ExistsIsbnDto dto = new ExistsIsbnDto(true);
		Long isbnQuery = repository.findByIsbn(isbn.getIsbnBook());
		
		if (isbnQuery == null) {
			dto.setExists(false);
		}
		
		return dto;
	}
}
