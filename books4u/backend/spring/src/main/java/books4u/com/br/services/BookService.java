package books4u.com.br.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.UpdatedDto;
import books4u.com.br.dto.book.BookDto;
import books4u.com.br.dto.book.BookInsertDto;
import books4u.com.br.entities.Author;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.BooksLocalization;
import books4u.com.br.entities.Genre;
import books4u.com.br.entities.PublishingCompany;
import books4u.com.br.repositories.AuthorRepository;
import books4u.com.br.repositories.BookRepository;
import books4u.com.br.repositories.BooksLocalizationRepository;
import books4u.com.br.repositories.GenreRepository;
import books4u.com.br.repositories.PublishingCompanyRepository;
import books4u.com.br.services.exceptions.DatabaseException;
import books4u.com.br.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private PublishingCompanyRepository pcRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BooksLocalizationRepository blRepository;
	
	@Transactional(readOnly = true)
	public List<BookDto> findAllDynamic(Integer amount) {
		List<Book> list = bookRepository.findAllDynamic(amount);
		return list.stream().map(x -> new BookDto(
				x, x.getGenre(), x.getPublishingCompany(), x.getAuthor(),
				x.getBooksLocalization()))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public BookDto findById(Long id) {
		Optional<Book> obj = bookRepository.findById(id);
		Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new BookDto(entity, entity.getGenre(), entity.getPublishingCompany(),
				entity.getAuthor(), entity.getBooksLocalization());
	}
	
	@Transactional(readOnly = true)
	public List<BookDto> findByIsbn(Long isbn){
		List<Book> list = bookRepository.findByBookIsbn(isbn);
		return list.stream().map(x -> new BookDto(
				x, x.getGenre(), x.getPublishingCompany(), x.getAuthor(),
				x.getBooksLocalization()))
				.collect(Collectors.toList()); 
	}
	
	@Transactional(readOnly = true)
	public List<BookDto> findByName(String name){
		try {
			List<Book> list = bookRepository.findByBookName(name);
			return list.stream().map(x -> new BookDto(
					x, x.getGenre(), x.getPublishingCompany(), x.getAuthor(),
					x.getBooksLocalization()))
					.collect(Collectors.toList());
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Illegal argument in search field");
		}
		 
	}
	
	@Transactional
	public Boolean insert(BookInsertDto dto) {
		Book book = bookRepository.findOneBookByIsbn(dto.getBookIsbn());
				
		if (book != null) {
			Book newBook = new Book();
			newBook = copyBookToNewOne(book, newBook);	
			bookRepository.save(newBook);
			return true;
		}
		try {	
			Book newBook = new Book();
			newBook = copyInsertDtoToEntity(dto, newBook);
			
			// drop down menu
			newBook.setGenre(genreRepository.findByGenreName((dto.getGenreName())));
			
			newBook.setAuthor(authorRepository.findOneAuthorByName(dto.getAuthorName()));
			if (newBook.getAuthor() == null) {
				Author author = new Author(null, dto.getAuthorName(), true);
				author = authorRepository.save(author);
				newBook.setAuthor(author);
			}
			
			newBook.setPublishingCompany(pcRepository
					.findOnePublishingCompanyByName(dto.getPublishingCompanyName()));
			if (newBook.getPublishingCompany() == null) {
				PublishingCompany pc = new PublishingCompany(null, dto.getPublishingCompanyName());
				pc = pcRepository.save(pc);
				newBook.setPublishingCompany(pc);
			}
			
			newBook.setBooksLocalization(blRepository.findLocalization(
					dto.getBookcaseNumber(), dto.getShelf()));
			if (newBook.getBooksLocalization() == null) {
				BooksLocalization bl = new BooksLocalization(null, dto.getBookcaseNumber(), dto.getShelf());
				bl = blRepository.save(bl);
				newBook.setBooksLocalization(bl);
			}
			
			newBook = bookRepository.save(newBook);
			return true;
		}
		catch (RuntimeException e) {
			return false;
		}
	}
	
	@Transactional
	public UpdatedDto update(Long id, BookDto dto) {
		try {
			Book entity = bookRepository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity.setGenre(genreRepository.findByGenreName(dto.getGenre().getName()));
			if (entity.getGenre() == null) {
				throw new DatabaseException("Gênero selecionado não existe");
			}
			entity.setBooksLocalization(blRepository.save(entity.getBooksLocalization()));
			entity = bookRepository.save(entity);
			return new UpdatedDto(true);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}

	public Boolean delete(Long id) {
		try {
			bookRepository.deleteById(id);
			return true;
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	public static Book copyInsertDtoToEntity(BookInsertDto dto, Book entity) {
		entity.setBookCopy(dto.getBookCopy());
		entity.setBookIsbn(dto.getBookIsbn());
		entity.setBookName(dto.getBookName());
		entity.setBookStatus(dto.getBookStatus());
		entity.setBookBorrowed(false);
		return entity;
	}
	
	public static void copyDtoToEntity(BookDto dto, Book entity) {
		entity.setBookCopy(dto.getCopy());
		entity.setBookIsbn(dto.getIsbn());
		entity.setBookName(dto.getName());
		entity.setBookStatus(dto.getStatus());
		entity.setBookBorrowed(dto.getBorrowed());
		
		entity.setGenre(new Genre(dto.getGenre().getId(), dto.getGenre().getName()));
		entity.setPublishingCompany(new PublishingCompany(
				dto.getPublishingCompany().getId(), dto.getPublishingCompany().getName()));
		entity.setAuthor(new Author(dto.getAuthor().getId(), dto.getAuthor().getName(),
				dto.getAuthor().getStatus()));
		entity.setBooksLocalization(new BooksLocalization(
				dto.getLocalization().getId(), dto.getLocalization().getBookcaseNumber(),
				dto.getLocalization().getShelf()));
	}
	
	public static Book copyBookToNewOne(Book book, Book newBook) {
		newBook.setBookCopy(book.getBookCopy() + 1);
		newBook.setBookIsbn(book.getBookIsbn());
		newBook.setBookName(book.getBookName());
		newBook.setBookStatus(book.getBookStatus());
		newBook.setBookBorrowed(false);
		
		newBook.setGenre(book.getGenre());
		newBook.setPublishingCompany(book.getPublishingCompany());
		newBook.setAuthor(book.getAuthor());
		newBook.setBooksLocalization(book.getBooksLocalization());
		return newBook;
	}
}
