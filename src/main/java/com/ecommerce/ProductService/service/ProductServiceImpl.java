package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.exception.ProductServiceCustomException;
import com.ecommerce.ProductService.model.ProductErrorCode;
import com.ecommerce.ProductService.model.ProductRequest;
import com.ecommerce.ProductService.model.ProductResponse;
import com.ecommerce.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProductServiceImpl implements IProductService {

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
    public ProductResponse getProduct(long productId) {
        log.info("Get product with the productId : {}", productId);
        Product product= productRepository
                .findById(String.valueOf(productId)).orElseThrow(() ->
                        new ProductServiceCustomException("Product not found with ID: "+productId, ProductErrorCode.PRODUCT_NOT_FOUND));

        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);

        return productResponse;
    }

    @Override
    public long reduceQuantity(long productId, long quantity) {
        log.info("Reducing product quantity for product with id : {}",productId);
        Product product= productRepository.findById(String.valueOf(productId)).orElseThrow(()->
                new ProductServiceCustomException("Product not found with ID: "+productId, ProductErrorCode.PRODUCT_NOT_FOUND));
        if(product.getProductQuantity()>=quantity){
            product.setProductQuantity(product.getProductQuantity()-quantity);
            productRepository.save(product);
            log.info("Products quantity reduced successfully..");
        }else{
            log.info("Insufficient quantity of products..");
            throw new ProductServiceCustomException("Insufficient quantity of products",ProductErrorCode.INSUFFICIENT_QUANTITY);
        }
        return product.getProductId();
    }
}
