package com.nisum.exception;


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book not found: " + id);
    }
}
