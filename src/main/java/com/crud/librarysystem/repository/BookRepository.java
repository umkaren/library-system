package com.crud.librarysystem.repository;

import com.crud.librarysystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
