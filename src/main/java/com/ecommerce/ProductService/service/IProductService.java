package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.model.ProductRequest;
import com.ecommerce.ProductService.model.ProductResponse;

public interface IProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProduct(long productId);

    long reduceQuantity(long productId, long quantity);
}
