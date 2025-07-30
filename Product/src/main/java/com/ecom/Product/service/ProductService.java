package com.ecom.Product.service;

import com.ecom.Product.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
}
