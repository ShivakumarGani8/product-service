package com.ecommerce.ProductService.exception;


import com.ecommerce.ProductService.model.ErrorCode;
import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException {
    private ErrorCode errorCode;

    public ProductServiceCustomException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
