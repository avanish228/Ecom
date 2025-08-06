package com.ecom.Product.controllers;

import com.ecom.Product.Entities.Product;
import com.ecom.Product.dto.ProductDto;
import com.ecom.Product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    ProductDto getById(@PathVariable Long id){

        if(id < 1){
            throw new IllegalArgumentException(" Invalid Argument");
        }

        return this.productService.getById(id);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Invalid Input: " + ex.getMessage());
    }

    @PostMapping
    ProductDto addProduct(@Valid @RequestBody ProductDto productDto){
        return this.productService.saveProduct(productDto);
    }

}
