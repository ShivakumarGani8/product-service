package com.ecommerce.ProductService.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private long quantity;
    private double price;
}
