package books4u.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.book.BookDeletedDto;
import books4u.com.br.dto.book.BookDto;
import books4u.com.br.dto.book.BookInsertDto;
import books4u.com.br.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/{amount}")
	public ResponseEntity<List<BookDto>> findAllDynamic(@PathVariable Integer amount){
		List<BookDto> list = service.findAllDynamic(amount);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/search/id/{id}")
	public ResponseEntity<BookDto> findById(@PathVariable Long id){
		BookDto dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping("/search/isbn/{isbn}")
	public ResponseEntity<List<BookDto>> findByIsbn(@PathVariable Long isbn){
		List<BookDto> list = service.findByIsbn(isbn);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/search/name/{name}")
	public ResponseEntity<List<BookDto>> findByName(@PathVariable String name){
		List<BookDto> list = service.findByName(name);
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping("/insert")
	public ResponseEntity<CreatedDto> insert(@RequestBody BookInsertDto bookDto){
		CreatedDto dto = service.insert(bookDto);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto dto){
		BookDto book = service.update(id, dto);
		return ResponseEntity.ok().body(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BookDeletedDto> delete(@PathVariable Long id){
		BookDeletedDto deleted = new BookDeletedDto(service.delete(id));
		return ResponseEntity.ok().body(deleted);
	}
}
