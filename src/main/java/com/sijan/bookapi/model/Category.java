package com.sijan.bookapi.model;

//import java.util.HashSet;
//import java.util.Set;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//
//@Entity
//public class Category {
//
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String name;
//	
//	@ManyToMany(mappedBy = "categories")
//	private Set<Book> books = new HashSet<>();
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Set<Book> getBooks() {
//		return books;
//	}
//
//	public void setBooks(Set<Book> books) {
//		this.books = books;
//	}
//	
//	
//}
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Book> getBooks() {
        return books;
    }
    
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}