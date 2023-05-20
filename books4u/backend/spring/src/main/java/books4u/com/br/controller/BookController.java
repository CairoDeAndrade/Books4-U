package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.book.BookIsbnDto;
import books4u.com.br.dto.book.ExistsIsbnDto;
import books4u.com.br.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@PostMapping
	public ResponseEntity<ExistsIsbnDto> existsIsbn(@RequestBody BookIsbnDto isbn){
		ExistsIsbnDto dto = service.existsIsbn(isbn);
		return ResponseEntity.ok().body(dto);
	}
}
