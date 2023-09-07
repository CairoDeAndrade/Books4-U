package books4u.com.br.services;

import books4u.com.br.dto.publishing.PublishingCompanyMinDto;
import books4u.com.br.entities.PublishingCompany;
import books4u.com.br.repositories.PublishingCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PublishingCompanyService {

    @Autowired
    private PublishingCompanyRepository repository;

    @Transactional
    public PublishingCompanyMinDto insert(PublishingCompanyMinDto dto) {
        PublishingCompany entity = new PublishingCompany();
        entity.setPublishingCompanyName(dto.getName());
        entity = repository.save(entity);
        return new PublishingCompanyMinDto(entity);
    }
}
