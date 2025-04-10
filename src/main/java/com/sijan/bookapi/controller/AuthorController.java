package com.sijan.bookapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sijan.bookapi.model.Author;
import com.sijan.bookapi.model.Book;
import com.sijan.bookapi.repository.AuthorRepository;
import com.sijan.bookapi.repository.BookRepository;
import com.sijan.bookapi.service.AuthorService;
import com.sijan.bookapi.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AuthorController {
	
	//ResponseEntity<Book> wraps the Book object 
		//in an HTTP response, giving you full control 
		//over what gets returned to the client.
		
//		Optional wraps the Book inside an Optional container, which might:
//			Contain a Book Or be empty (no book found)
//			So instead of returning null, it gives you a safe way to handle the absence of value.



//	Use @PathVariable for WHAT you want.
//	Use @RequestParam for HOW you want it.
	// @PathVariable is used in GET/DELETE to extract data from URL
	// @RequestBody is used in POST/PUT to read JSON data from request body

	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@GetMapping("/author/{authorid}")
	public Author getAuthor(@PathVariable Long authorid) {
		return authorService.getAuthor(authorid);
	}
	
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author);

	}
	
	@GetMapping("/authors/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathVariable Long authorId) {
		return bookService.getBooksByAuthor(authorId);
    }
	
	@PostMapping("/authors/{authorId}/books/{bookId}")
    public Book addBookToAuthor(
            @PathVariable Long authorId,
            @PathVariable Long bookId) {
					
		return bookService.addBooktoAuthor(authorId,bookId);
        
////        return authorrepo.findById(authorId)
////            .map(author -> {
////                bookRequest.setAuthor(author);
////                Book savedBook = bookRepository.save(bookRequest);
////                return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
////            })
////            .orElseGet(() -> ResponseEntity.notFound().build());
////   }
////		The map function is a method from the Optional class. In this case, it operates on the Optional<Author> returned by authorrepo.findById(authorId).
////		If the author exists (the Optional contains a value), the map will execute the code inside the lambda.
////		If the author doesn't exist (the Optional is empty), it will skip the map and execute orElseGet().
	}
	
	
}
	