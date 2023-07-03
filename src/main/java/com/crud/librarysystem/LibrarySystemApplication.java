package com.crud.librarysystem;

import com.crud.librarysystem.model.Book;
import com.crud.librarysystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrarySystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
