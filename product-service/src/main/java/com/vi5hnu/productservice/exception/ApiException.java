package com.vi5hnu.productservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ApiException(HttpStatus httpStatus,String message){
        super(message);
        this.status=httpStatus;
    }
}
