package com.crud.librarysystem.repository;

import com.crud.librarysystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
