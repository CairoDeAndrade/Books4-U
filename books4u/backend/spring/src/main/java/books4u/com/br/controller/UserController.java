package books4u.com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books4u.com.br.dto.user.LoggedDto;
import books4u.com.br.dto.user.UserLoginDto;
import books4u.com.br.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoggedDto> login(@RequestBody UserLoginDto dto){
		LoggedDto logged = service.login(dto);
		return ResponseEntity.ok().body(logged);
	}

}
