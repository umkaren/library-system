package com.crud.librarysystem.controller;

import com.crud.librarysystem.model.Author;
import com.crud.librarysystem.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    // create author object to hold author form data
    @GetMapping("/new")
    public String createAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "create_author";
    }

    @PostMapping("")
    public String saveAuthor(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_author";
        }

        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String editAuthorForm(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "edit_author";
    }

    @PostMapping("/{id}")
    public String editAuthor(@PathVariable Long id, @ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_author";
        }
        Author existingAuthor = authorService.getAuthorById(id);
        existingAuthor.setName(author.getName());
        authorService.updateAuthor(existingAuthor);
        return "redirect:/authors";
    }

    @GetMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
