package com.sijan.bookapi.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sijan.bookapi.model.Author;
import com.sijan.bookapi.model.Book;
import com.sijan.bookapi.model.Category;
import com.sijan.bookapi.repository.AuthorRepository;
import com.sijan.bookapi.repository.BookRepository;
import com.sijan.bookapi.repository.CategoryRepository;


@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired 
	AuthorService authorService;
	@Autowired 
	CategoryService categoryService;
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	public Book getBook(Long bookId) {

		return bookRepo.findById(bookId)
				.orElseThrow(()->new RuntimeException("Author not found with id "+ bookId));
	}
	public Book addBook(Book book) {

		return bookRepo.save(book);
	}

	public Book addBooktoAuthor(Long authorId, Long bookId) {
		Author author = authorService.getAuthor(authorId);
		Book book = getBook(bookId);
	    author.getBooks().add(book);
	    book.setAuthor(author);
	    return bookRepo.save(book);
	}
	
	public Book addCategoryToBook(Long bookId, Long categoryId) {
		Book book = getBook(bookId);
	    Category category = categoryService.getCategory(categoryId);

	    book.getCategories().add(category);

	    category.getBooks().add(book);
	    
	    //CascadeType.ALL will ensure the Category is also updated if needed
	    return bookRepo.save(book);
		
	}
	public Set<Category> getCategories(Long bookId) {
		Book book =  getBook(bookId);
		return book.getCategories();
		
	}
	public List<Book> getBooksByAuthor(Long authorId) {
		
		return bookRepo.findByAuthorId(authorId);
	}

	



}
