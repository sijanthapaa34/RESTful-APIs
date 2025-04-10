package com.sijan.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sijan.bookapi.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long >{

}
