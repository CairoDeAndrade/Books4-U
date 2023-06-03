package books4u.com.br.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.book.BookCreatedDto;
import books4u.com.br.dto.book.BookInsertDto;
import books4u.com.br.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@PostMapping("/insert")
	public ResponseEntity<BookCreatedDto> insert(@RequestBody BookInsertDto bookDto) throws SQLException{
		BookCreatedDto dto = service.insert(bookDto);
		return ResponseEntity.ok().body(dto);
	}
}
