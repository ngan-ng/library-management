package com.application.courselibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.courselibrary.repository.CategoryRepository;
import com.application.courselibrary.entities.Category;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
        return category;
    }

    public void createCategory(Category publisher) {
        categoryRepository.save(publisher);
    }

    public void updateCategory(Category publisher) {
        categoryRepository.save(publisher);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
        categoryRepository.deleteById(category.getId());
    }
}
