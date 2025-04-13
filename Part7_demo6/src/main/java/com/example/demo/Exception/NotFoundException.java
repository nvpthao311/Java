package com.example.demo.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id, String obj) {
        super( obj + " with ID " + id + " not found.");
    }
}
