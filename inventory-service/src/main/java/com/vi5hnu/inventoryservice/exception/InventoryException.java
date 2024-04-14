package com.vi5hnu.inventoryservice.exception;

import org.springframework.http.HttpStatus;

public class InventoryException extends RuntimeException{
    HttpStatus sataus;
    public InventoryException(HttpStatus status, String message){
        super(message);
        this.sataus=status;
    }
}
