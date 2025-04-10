package com.sijan.bookapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sijan.bookapi.model.Book;
import com.sijan.bookapi.model.Category;
import com.sijan.bookapi.repository.BookRepository;
import com.sijan.bookapi.repository.CategoryRepository;
import com.sijan.bookapi.service.BookService;
import com.sijan.bookapi.service.CategoryService;

@RestController
public class BookController {

	@Autowired
    private BookService bookService;
    
    @Autowired
    private CategoryService categoryService;
    
    
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
    	return bookService.getBook(bookId);
    }
    
    @PostMapping("/books")
    public Book addBooks(
	          @RequestBody Book book) {
    	return bookService.addBook(book);
    }
    @PostMapping("/books/{bookId}/categories/{categoryId}")
    public Book addCategoryToBook(
	          @PathVariable Long bookId,
	          @PathVariable Long categoryId) {
    	return bookService.addCategoryToBook(bookId,categoryId);
    }
    @GetMapping("/books/{bookId}/categories")
  public Set<Category> getCategoriesByBook(@PathVariable Long bookId) {
  	return bookService.getCategories(bookId);

  }
    
}