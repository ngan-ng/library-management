package com.application.courselibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courselibrary.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
    
}
