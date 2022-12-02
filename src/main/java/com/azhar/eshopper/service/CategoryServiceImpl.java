package com.azhar.eshopper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhar.eshopper.model.Category;
import com.azhar.eshopper.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> findAllCategory() {
        // TODO Auto-generated method stub
        return categoryRepo.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        // TODO Auto-generated method stub
        return categoryRepo.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long cateId) {
        // TODO Auto-generated method stub
        return categoryRepo.findById(cateId);
    }

    @Override
    public void deleteCategoryById(Long cateId) {
        // TODO Auto-generated method stub
        categoryRepo.deleteById(cateId);
    }
    
}
