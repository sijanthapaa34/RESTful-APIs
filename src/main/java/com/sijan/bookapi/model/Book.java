package com.sijan.bookapi.model;

//import java.util.HashSet;
//import java.util.Set;
//
//import org.hibernate.annotations.ManyToAny;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Book {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	 private Long id;
//	 
//	 private String title;
//	 
// 	@ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;
//    
//    @ManyToMany
//    @JoinTable(
//        name = "book_category",
//        joinColumns = @JoinColumn(name = "book_id"),
//        inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private Set<Category> categories = new HashSet<>();
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
//
//	public Set<Category> getCategories() {
//		return categories;
//	}
//
//	public void setCategories(Set<Category> categories) {
//		this.categories = categories;
//	}
//
//	 
//	
//}
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    @ManyToMany
    @JoinTable(
        name = "book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Set<Category> getCategories() {
        return categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}