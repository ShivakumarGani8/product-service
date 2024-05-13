package com.ecommerce.ProductService.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private long quantity;
    private double price;
}
