package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.CreatedDto;
import books4u.com.br.dto.loan.LoanInsertDto;
import books4u.com.br.services.LoanService;

@RestController("/loans")
public class LoanController {
	
	@Autowired
	private LoanService service;
	
//	@PostMapping("/insert")
//	public ResponseEntity<CreatedDto> insert(@RequestBody LoanInsertDto dto){
//		CreatedDto created = new CreatedDto(service.insert(dto));
//		return ResponseEntity.ok().body(created);
//	}
}
