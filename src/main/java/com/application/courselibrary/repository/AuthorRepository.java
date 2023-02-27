package com.application.courselibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courselibrary.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
