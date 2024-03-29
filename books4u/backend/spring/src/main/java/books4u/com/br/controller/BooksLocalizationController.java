package books4u.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import books4u.com.br.dto.booksloc.BooksLocalizationMinDto;
import books4u.com.br.services.BooksLocalizationService;

@RestController
@RequestMapping("/localizations")
public class BooksLocalizationController {
	
	@Autowired
	private BooksLocalizationService service;
	
	@GetMapping
	public ResponseEntity<List<BooksLocalizationMinDto>> findAll() {
		List<BooksLocalizationMinDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/insert")
	public ResponseEntity<BooksLocalizationMinDto> insert(@RequestBody BooksLocalizationMinDto dto) {
		return ResponseEntity.ok().body(service.insert(dto));
	}
}
