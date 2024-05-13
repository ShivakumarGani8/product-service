package com.ecommerce.ProductService.exception;

import com.ecommerce.ProductService.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorMessage> handleProductNotFoundException(ProductServiceCustomException exception){
        ErrorMessage.ErrorMessageBuilder builder = ErrorMessage.builder();
        builder.errorMessage(exception.getMessage());
        builder.errorCode(exception.getErrorCode());
        ErrorMessage errorMessage= builder.build();

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
