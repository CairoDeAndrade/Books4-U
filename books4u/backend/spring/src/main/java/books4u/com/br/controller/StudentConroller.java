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
import books4u.com.br.dto.DeletedDto;
import books4u.com.br.dto.UpdatedDto;
import books4u.com.br.dto.student.StudentDto;
import books4u.com.br.dto.student.StudentInsertDto;
import books4u.com.br.dto.student.StudentWithClassDto;
import books4u.com.br.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentConroller {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/{amount}")
	public ResponseEntity<List<StudentDto>> findAllDynamic(@PathVariable Integer amount){
		List<StudentDto> list = service.finadAllDynamic(amount);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/enrollment={enrollment}")
	public ResponseEntity<StudentWithClassDto> findByEnrollment(@PathVariable Long enrollment){
		StudentWithClassDto student = service.findByEnrollment(enrollment);
		return ResponseEntity.ok().body(student);
	}
	
	@GetMapping("/name={name}")
	public ResponseEntity<List<StudentWithClassDto>> findByName(@PathVariable String name){
		List<StudentWithClassDto> students = service.findByName(name);
		return ResponseEntity.ok().body(students);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<CreatedDto> insert(@RequestBody StudentInsertDto dto){
		CreatedDto created = new CreatedDto(service.insert(dto));
		return ResponseEntity.ok().body(created);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UpdatedDto> update(@PathVariable Long id, @RequestBody StudentDto dto){
		UpdatedDto updated = service.update(id, dto);
		return ResponseEntity.ok().body(updated);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DeletedDto> delete(@PathVariable Long id){
		DeletedDto deleted = new DeletedDto(service.delete(id));
		return ResponseEntity.ok().body(deleted);
	}
}
