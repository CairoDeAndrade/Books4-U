package books4u.com.br.controller;

import books4u.com.br.dto.author.AuthorMinDto;
import books4u.com.br.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping("/insert")
    public ResponseEntity<AuthorMinDto> insert(@RequestBody AuthorMinDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }
}
