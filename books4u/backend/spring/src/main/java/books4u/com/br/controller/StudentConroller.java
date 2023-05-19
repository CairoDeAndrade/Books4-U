package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentConroller {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/save")
	public ResponseEntity<Boolean> save() {
		boolean javaMelhorQuePhp = service.save();
		return ResponseEntity.ok().body(javaMelhorQuePhp);
	}
}
