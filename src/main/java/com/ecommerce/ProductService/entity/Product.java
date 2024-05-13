package com.ecommerce.ProductService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_QUANTITY")
    private long productQuantity;

    @Column(name = "PRODUCT_PRICE")
    private double productPrice;
}
