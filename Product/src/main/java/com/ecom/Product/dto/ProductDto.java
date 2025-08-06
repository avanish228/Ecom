package com.ecom.Product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;

    @Min(value = 1, message = "Quantity must more than 1")
    private int quantity;

    private Long categoryId;
}
