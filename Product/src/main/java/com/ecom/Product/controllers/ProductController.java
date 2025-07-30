package com.ecom.Product.controllers;

import com.ecom.Product.Entities.Product;
import com.ecom.Product.dto.ProductDto;
import com.ecom.Product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<ProductDto> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PostMapping
    ProductDto addProduct(@RequestBody ProductDto productDto){
        return this.productService.saveProduct(productDto);
    }

}
