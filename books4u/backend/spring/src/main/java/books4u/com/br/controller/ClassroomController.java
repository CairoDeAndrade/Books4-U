package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.ClassroomDto;
import books4u.com.br.services.ClassroomService;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
	
	@Autowired
	private ClassroomService service;
	
	@PostMapping
	public ResponseEntity<ClassroomDto> insert(@RequestBody ClassroomDto dto){
		dto = service.insert(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
