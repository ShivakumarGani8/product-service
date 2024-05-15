package com.ecommerce.ProductService.exception;


import com.ecommerce.ProductService.model.ProductErrorCode;
import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException {
    private ProductErrorCode errorCode;

    public ProductServiceCustomException(String message, ProductErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
