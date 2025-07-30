package com.ecom.Product.controllers;

import com.ecom.Product.dto.CategoryDto;
import com.ecom.Product.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<CategoryDto> getAllCategories(){
        return this.categoryService.getAllCategories();
    }

    @PostMapping
    CategoryDto setCategory(@RequestBody CategoryDto categoryDto){
        return this.categoryService.saveCategory(categoryDto);
    }



}
