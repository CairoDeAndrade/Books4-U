package books4u.com.br.controller;

import books4u.com.br.dto.publishing.PublishingCompanyMinDto;
import books4u.com.br.services.PublishingCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class PublishingCompanyContoller {

    @Autowired
    private PublishingCompanyService service;

    @PostMapping("/insert")
    public ResponseEntity<PublishingCompanyMinDto> insert(@RequestBody PublishingCompanyMinDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }
}
