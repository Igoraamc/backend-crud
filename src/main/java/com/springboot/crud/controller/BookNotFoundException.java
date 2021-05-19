package com.springboot.crud.controller;

public class BookNotFoundException extends RuntimeException {
    BookNotFoundException(Long id) {
        super("Could not find book " + id);
    }
}
