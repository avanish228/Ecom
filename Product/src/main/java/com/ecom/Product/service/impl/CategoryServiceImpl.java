package com.ecom.Product.service.impl;

import com.ecom.Product.Entities.Category;
import com.ecom.Product.dto.CategoryDto;
import com.ecom.Product.repository.CategoryRepository;
import com.ecom.Product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category = categoryRepository.save(category);
        dto.setId(category.getId());
        return dto;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> {
                    CategoryDto dto = new CategoryDto();
                    dto.setId(c.getId());
                    dto.setName(c.getName());
                    return dto;
                }).collect(Collectors.toList());
    }
}
