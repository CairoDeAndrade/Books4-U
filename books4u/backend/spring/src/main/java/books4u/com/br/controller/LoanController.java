package books4u.com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.loan.LoanInsertDto;
import books4u.com.br.projections.LoanProjection;
import books4u.com.br.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService service;
	
	@GetMapping
	public ResponseEntity<List<LoanProjection>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/studentEnrollment={enrollment}")
	public ResponseEntity<List<LoanProjection>> findAllLoansByStudent(@PathVariable Long enrollment){
		return ResponseEntity.ok().body(service.findAllLoansByStudent(enrollment));
	}
	
	@PostMapping("/insert")
	public ResponseEntity<CreatedDto> insert(@RequestBody LoanInsertDto dto){
		CreatedDto created = new CreatedDto(service.insert(dto));
		return ResponseEntity.ok().body(created);
	}
}
