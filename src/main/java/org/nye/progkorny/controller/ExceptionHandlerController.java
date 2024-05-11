package org.nye.progkorny.controller;

import org.nye.progkorny.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found in the database.")
    @ExceptionHandler(BookNotFoundException.class)
    public void handleBookNotFoundException() {

    }
}
