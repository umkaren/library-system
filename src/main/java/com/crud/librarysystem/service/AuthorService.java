package com.crud.librarysystem.service;

import com.crud.librarysystem.model.Author;
import com.crud.librarysystem.model.Book;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Author getAuthorById(Long id);

    void deleteAuthorById(Long id);
}
