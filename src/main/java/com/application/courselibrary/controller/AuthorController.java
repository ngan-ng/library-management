package com.application.courselibrary.controller;

import com.application.courselibrary.entities.Author;
import com.application.courselibrary.entities.Publisher;
import com.application.courselibrary.service.AuthorService;
import com.application.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteAuthors(@PathVariable Long id, Model model) {
        authorService.deleteAuthor(id);
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.findAuthorById(id));
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String saveAuthor(@PathVariable Long id, Author author, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "update-author";
        }

        authorService.updateAuthor(author);
        model.addAttribute("authors", authorService.findAllAuthors());

        return "redirect:/authors";
    }

    @GetMapping("/add-author")
    public String showCreateAuthor(Author author) {
        return "add-author";
    }

    @PostMapping("/save-author")
    public String createAuthor(Author author, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "add-author";
        }

        authorService.createAuthor(author);
        model.addAttribute("authors", authorService.findAllAuthors());

        return "redirect:/authors";
    }
}
