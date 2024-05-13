package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.exception.ProductServiceCustomException;
import com.ecommerce.ProductService.model.ProductRequest;
import com.ecommerce.ProductService.model.ProductResponse;
import com.ecommerce.ProductService.repository.ProductRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProductServiceImpl implements IProductServie{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product to the table...");
        Product product= Product.builder().productName(productRequest.getName())
                .productQuantity(productRequest.getQuantity())
                .productPrice(productRequest.getPrice()).build();

        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProduct(String productId) {
        log.info("Get product with the productId : {}", productId);
        Product product= productRepository
                .findById(productId).orElseThrow(() ->
                        new ProductServiceCustomException("Product not found with ID: "+productId,"PRODUCT_NOT_FOUND"));

        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);

        return productResponse;
    }
}
