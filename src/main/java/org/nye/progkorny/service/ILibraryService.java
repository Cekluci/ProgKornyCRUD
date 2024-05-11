package org.nye.progkorny.service;

import org.nye.progkorny.entity.BookEntity;
import org.nye.progkorny.request.BookRequest;

import java.util.List;

public interface ILibraryService {

    BookEntity saveBook(BookRequest bookRequest);

    BookEntity getBookById(Long id);

    BookEntity updateBook(Long id, BookRequest bookRequest);

    void deleteBookById(Long id);

    List<BookEntity> findAllByAuthor(String author);

    List<BookEntity> findAllByYear(int year);

    List<BookEntity> findAllByGenre(String genre);

}
