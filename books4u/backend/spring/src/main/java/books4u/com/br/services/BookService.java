package books4u.com.br.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.book.BookCreatedDto;
import books4u.com.br.dto.book.BookInsertDto;
import books4u.com.br.entities.Author;
import books4u.com.br.entities.Book;
import books4u.com.br.entities.PublishingCompany;
import books4u.com.br.repositories.AuthorRepository;
import books4u.com.br.repositories.BookRepository;
import books4u.com.br.repositories.BooksLocalizationRepository;
import books4u.com.br.repositories.GenreRepository;
import books4u.com.br.repositories.PublishingCompanyRepository;

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
	
	@Transactional
	public BookCreatedDto insert(BookInsertDto dto) throws SQLException {
		BookCreatedDto created = new BookCreatedDto(false);
		Book book = bookRepository.findOneBookByIsbn(dto.getBookIsbn());
				
		if (book != null) {
			Book newBook = new Book();
			newBook = copyBookToNewOne(book, newBook);	
			bookRepository.save(newBook);
			created.setCreated(true);
		}
		else {	
			Book newBook = new Book();
			newBook = copyDtoToEntity(dto, newBook);
			
			// drop down menu
			newBook.setGenre(genreRepository.findOneGenreByName((dto.getGenreName())));
			
			newBook.setAuthor(authorRepository.findOneAuthorByName(newBook.getBookName()));
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
			
			// drop down menu
			newBook.setBooksLocalization(blRepository.findLocalization(
					dto.getBookcaseNumber(), dto.getShelf()));
			
			newBook = bookRepository.save(newBook);
			created.setCreated(true);
		}
		return created;
	}
	
	public static Book copyDtoToEntity(BookInsertDto dto, Book entity) {
		entity.setBookCopy(dto.getBookCopy());
		entity.setBookIsbn(dto.getBookIsbn());
		entity.setBookName(dto.getBookName());
		entity.setBookStatus(dto.getBookStatus());
		return entity;
	}
	
	public static Book copyBookToNewOne(Book book, Book newBook) {
		newBook.setBookCopy(book.getBookCopy() + 1);
		newBook.setBookIsbn(book.getBookIsbn());
		newBook.setBookName(book.getBookName());
		newBook.setBookStatus(book.getBookStatus());
		
		newBook.setGenre(book.getGenre());
		newBook.setPublishingCompany(book.getPublishingCompany());
		newBook.setAuthor(book.getAuthor());
		newBook.setBooksLocalization(book.getBooksLocalization());
		return newBook;
	}
}
