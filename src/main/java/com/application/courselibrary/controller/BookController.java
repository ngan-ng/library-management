package com.application.courselibrary.controller;

import com.application.courselibrary.entities.Book;
import com.application.courselibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books); //this list is added to model object
        return "books"; //name of html file, will render this books
    }
}