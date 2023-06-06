package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.genre.GenreDto;
import books4u.com.br.services.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {
	
	@Autowired
	private GenreService service;
	
	@GetMapping
	public ResponseEntity<Page<GenreDto>> findAll(Pageable pageable) {
		Page<GenreDto> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}
}
