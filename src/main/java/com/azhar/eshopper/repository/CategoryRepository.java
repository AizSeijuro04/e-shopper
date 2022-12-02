package com.azhar.eshopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhar.eshopper.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
    
}
