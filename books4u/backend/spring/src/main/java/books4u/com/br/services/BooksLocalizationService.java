package books4u.com.br.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.booksloc.BooksLocalizationMinDto;
import books4u.com.br.entities.BooksLocalization;
import books4u.com.br.repositories.BooksLocalizationRepository;

@Service
public class BooksLocalizationService {
	
	@Autowired
	private BooksLocalizationRepository repository;
	
	@Transactional(readOnly = true)
	public List<BooksLocalizationMinDto> findAll() {
		List<BooksLocalization> entities = repository.findAll();
		return entities.stream().map(x -> new BooksLocalizationMinDto(x))
				.collect(Collectors.toList());
	}
}
