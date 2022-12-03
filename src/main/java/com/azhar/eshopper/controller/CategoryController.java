package com.azhar.eshopper.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.azhar.eshopper.model.Category;
import com.azhar.eshopper.service.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String showCategory(Model model){
        model.addAttribute("isHome", false);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "modules/category/category.html";
    }

    @GetMapping("add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("action", "Add Category");
        return "modules/category/addEdit.html";
    }

    @PostMapping("add")
    public String postCategory(@Valid Category category, BindingResult result,RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "modules/category/addEdit.html";
        }
        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("message", "Category"+category.getCateName()+"created");
        return "redirect:/category/";
    }

    @GetMapping("edit/{id}")
    public String editCategoryById(@PathVariable("id") Long cateId,Model model){
        Optional<Category> category = categoryService.findCategoryById(cateId);
        model.addAttribute("action", "Edit Category");
        model.addAttribute("category", category.get());
        return "modules/category/addEdit.html";
    }

    @GetMapping("delete/{id}")
    public String deleteCategoryById(@PathVariable("id")Long cateId, RedirectAttributes redirectAttributes ){
        categoryService.deleteCategoryById(cateId);
        redirectAttributes.addFlashAttribute("message", "category " + cateId + "has been deleted.");
        return "redirect:/category/";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req,Exception exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("404.html");
        return mav;
    }
}
