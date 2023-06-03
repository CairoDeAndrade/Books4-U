package books4u.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<GenreDto>> findAll(){
		List<GenreDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
