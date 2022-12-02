package com.azhar.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.azhar.eshopper.model.Category;

public interface CategoryService {
    List<Category> findAllCategory();

    //add category to database
    Category addCategory(Category category);

    Optional<Category> findCategoryById(Long cateId);

    void deleteCategoryById(Long cateId);
    
}
