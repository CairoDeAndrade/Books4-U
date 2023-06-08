package books4u.com.br.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.book.BookCreatedDto;
import books4u.com.br.dto.book.BookDto;
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
	
	@GetMapping("/{amount}")
	public ResponseEntity<List<BookDto>> findAllDynamic(@PathVariable Integer amount){
		List<BookDto> list = service.findAllDynamic(amount);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<List<BookDto>> findByIsbn(@PathVariable Long isbn){
		List<BookDto> list = service.findByIsbn(isbn);
		return ResponseEntity.ok().body(list);
	}
}
