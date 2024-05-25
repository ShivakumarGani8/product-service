package com.ecommerce.ProductService.exception;

import com.ecommerce.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductServiceCustomException exception){
        ErrorResponse.ErrorResponseBuilder builder = ErrorResponse.builder();
        builder.errorMessage(exception.getMessage());
        builder.errorCode(exception.getErrorCode());
        ErrorResponse errorMessage= builder.build();

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
