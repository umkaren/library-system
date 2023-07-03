package com.crud.librarysystem.service.impl;

import com.crud.librarysystem.model.Author;
import com.crud.librarysystem.repository.AuthorRepository;
import com.crud.librarysystem.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        // Check if the author exists in the database
        Author existingAuthor = authorRepository.findById(author.getId()).orElse(null);
        if (existingAuthor != null) {
            // Update the author's fields
            existingAuthor.setName(author.getName());
            existingAuthor.setBooks(author.getBooks());

            // Save the updated author
            return authorRepository.save(existingAuthor);
        }
        return null; // Or throw an exception indicating the author was not found
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
