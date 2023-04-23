package com.application.courselibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.courselibrary.entities.Author;
import com.application.courselibrary.repository.AuthorRepository;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
        return author;
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
        authorRepository.deleteById(author.getId());
    }
}
