package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
