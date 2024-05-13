package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.model.ProductRequest;
import com.ecommerce.ProductService.model.ProductResponse;

public interface IProductServie {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProduct(String productId);
}
