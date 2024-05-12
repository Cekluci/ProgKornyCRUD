package org.nye.progkorny.controller;

import jakarta.validation.Valid;
import org.nye.progkorny.entity.BookEntity;
import org.nye.progkorny.request.BookRequest;
import org.nye.progkorny.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BookController {

    @Autowired
    private ILibraryService libraryService;

    @GetMapping("/books/allBooks")
    public List<BookEntity> getAllBooks() {
        return libraryService.getAllBooks();
    }
    @PostMapping("/books")
    public BookEntity saveBook(@RequestBody @Valid BookRequest request) {
        return libraryService.saveBook(request);
    }

    @GetMapping("/books/{id}")
    public BookEntity getbook(@PathVariable("id") Long id) {
        return libraryService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public BookEntity saveBook(@PathVariable("id") Long id, @RequestBody BookRequest request) {
        return libraryService.updateBook(id, request);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        libraryService.deleteBookById(id);
    }

    @GetMapping("/books/author/{author}")
    public List<BookEntity> getAllBooksByAuthor(@PathVariable("author") String author) {
        return libraryService.findAllByAuthor(author);
    }

    @GetMapping("/books/year/{publicationYear}")
    public List<BookEntity> getAllBooksByYear(@PathVariable("publicationYear") int publicationYear) {
        return libraryService.findAllByYear(publicationYear);
    }

    @GetMapping("books/genres/{genre}")
    public List<BookEntity> getAllBooksByGenre(@PathVariable("genre") String genre) {
        return libraryService.findAllByGenre(genre);
    }
}
