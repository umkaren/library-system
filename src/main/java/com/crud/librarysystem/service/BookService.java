package com.crud.librarysystem.service;

import com.crud.librarysystem.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book saveBook(Book book);

    Book updateBook(Book book);

    Book getBookById(Long id);

    void deleteBookById(Long id);
}
