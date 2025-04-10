package com.sijan.bookapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sijan.bookapi.model.Author;
import com.sijan.bookapi.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;

	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	public Author getAuthor(Long authorid) {

		return authorRepo.findById(authorid)
				.orElseThrow(()->new RuntimeException("Author not found with id "+ authorid));
	}

	public Author saveAuthor(Author author) {
		return authorRepo.save(author);
	}

}
