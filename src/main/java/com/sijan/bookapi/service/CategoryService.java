package com.sijan.bookapi.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sijan.bookapi.model.Book;
import com.sijan.bookapi.model.Category;
import com.sijan.bookapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> findAllCategories() {

		return categoryRepo.findAll();
	}

	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	public Category getCategory(Long categoryId) {
		return categoryRepo.findById(categoryId)
		.orElseThrow(()->new RuntimeException("Category not found with id "+ categoryId));
	}

	public Set<Book> getBooksByCategory(Long categoryId) {
		Category category = getCategory(categoryId);
		return category.getBooks();
	}

}
