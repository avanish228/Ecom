package com.ecom.Product.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    BigDecimal price;

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // or optional = true if nullable
    @JoinColumn(name = "category_id")
    @JsonBackReference
    Category category;

}
