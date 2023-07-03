package com.crud.librarysystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Title may not be empty")
    @Size(min = 1, message = "Minimal character limit for a title is one character")
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull(message = "Author is required")
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

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

    //constructors
    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
}
