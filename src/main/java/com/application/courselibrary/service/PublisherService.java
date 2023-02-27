package com.application.courselibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.courselibrary.repository.PublisherRepository;
import com.application.courselibrary.entities.Publisher;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findAuthorById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
        return publisher;
    }

    public void createAuthor(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deleteAuthor(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
        publisherRepository.deleteById(publisher.getId());
    }
    
}
