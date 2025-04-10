package com.sijan.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sijan.bookapi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
