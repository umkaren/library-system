package com.crud.librarysystem.controller;

import com.crud.librarysystem.model.Book;
import com.crud.librarysystem.service.AuthorService;
import com.crud.librarysystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    // handler method to handle list of books and return model and view

    @GetMapping("")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // create book object to hold book form data
    @GetMapping("/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "create_book";
    }

    @PostMapping("")
    public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_book";
        }

        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "edit_book";
    }

    @PostMapping("/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_book";
        }

        Book existingBook = bookService.getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());

        //save updated book object
        bookService.updateBook(existingBook);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
}
