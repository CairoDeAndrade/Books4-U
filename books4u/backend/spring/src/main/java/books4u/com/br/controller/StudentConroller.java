package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.student.StudentInsertDto;
import books4u.com.br.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentConroller {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/insert")
	public ResponseEntity<CreatedDto> insert(@RequestBody StudentInsertDto dto){
		CreatedDto created = service.insert(dto);
		return ResponseEntity.ok().body(created);
	}
}
