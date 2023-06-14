package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.student.StudentInsertDto;
import books4u.com.br.dto.student.StudentSearchDto;
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
	
	@GetMapping("/matricula={enrollment}")
	public ResponseEntity<StudentSearchDto> findByEnrollment(@PathVariable Long enrollment){
		StudentSearchDto student = service.findByEnrollment(enrollment);
		return ResponseEntity.ok().body(student);
	}
	
	@GetMapping("/name={name}")
	public ResponseEntity<StudentSearchDto> findByName(@PathVariable String name){
		StudentSearchDto student = service.findByName(name);
		return ResponseEntity.ok().body(student);
	}
}
