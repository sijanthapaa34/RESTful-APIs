package com.sijan.bookapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sijan.bookapi.model.Book;
import com.sijan.bookapi.model.Category;
import com.sijan.bookapi.repository.AuthorRepository;
import com.sijan.bookapi.repository.BookRepository;
import com.sijan.bookapi.repository.CategoryRepository;
import com.sijan.bookapi.service.CategoryService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CategoryController {
	
	 @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
        
    }

    @GetMapping("/categories/{categoryId}/books")
    public Set<Book> getBooksByCategory(@PathVariable Long categoryId) {

        return categoryService.getBooksByCategory(categoryId);
                
    }

}
	
