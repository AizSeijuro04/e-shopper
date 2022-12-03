package com.azhar.eshopper;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.azhar.eshopper.model.Category;
import com.azhar.eshopper.repository.CategoryRepository;
import com.azhar.eshopper.service.CategoryService;

@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryRepository cateRepo;

    @Autowired
    private CategoryService cateService;


    @Test
    public void createCategorySrv(){
        Category category = new Category(null,"JACKET");
        cateService.addCategory(category);
        Assertions.assertEquals(6, cateRepo.count());
    }

    @Test
    public void findCategoryIdByService(){
        Optional<Category> category =cateService.findCategoryById(5L);
        Assertions.assertEquals("JEANS", category.get().getCateName());
    }

    @Test
    public void deleteCategoryIdByService(){
        cateService.deleteCategoryById(2L);
    }


    @Test
    public void createCategory(){
        Category category = new Category(null,"JEANS");
        cateRepo.save(category);
        Assertions.assertEquals(5, cateRepo.count());

    }

    @Test
    public void findById(){
        Optional<Category> category = cateRepo.findById(1L);
        Assertions.assertEquals("T-SHIRT", category.get().getCateName());
    }
}
