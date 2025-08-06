package com.ecom.Product.service.impl;

import com.ecom.Product.Entities.Product;
import com.ecom.Product.dto.ProductDto;
import com.ecom.Product.repository.CategoryRepository;
import com.ecom.Product.repository.ProductRepository;
import com.ecom.Product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        Product product=new Product();
        product.setName(productDto.getName());
        product.setCategory(this.categoryRepository.getById(productDto.getCategoryId()));
        product.setPrice(productDto.getPrice());
        product.setQuantity(product.getQuantity());
        this.productRepository.save(product);

        productDto.setId(product.getId());

        return productDto;


    }

    @Override
    public List<ProductDto> getAllProducts() {
        return this.productRepository.findAll().stream().map( product -> {
            ProductDto productDto=new ProductDto();
            productDto.setId(product.getId());
            productDto.setQuantity(product.getQuantity());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setCategoryId(product.getCategory().getId());
            return productDto;
        }).toList();
    }

    @Override
    public ProductDto getById(Long id) {
        Product product= this.productRepository.findById(id).orElseThrow( () -> new IllegalArgumentException());
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setQuantity(product.getQuantity());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());

        return productDto;
    }
}
