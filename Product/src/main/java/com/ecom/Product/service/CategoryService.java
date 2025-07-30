package com.ecom.Product.service;

import com.ecom.Product.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();
}
