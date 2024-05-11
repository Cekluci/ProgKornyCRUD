package org.nye.progkorny.service;

import lombok.SneakyThrows;
import org.nye.progkorny.entity.BookEntity;
import org.nye.progkorny.repository.ILibraryRepository;
import org.nye.progkorny.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nye.progkorny.exception.BookNotFoundException;

import java.util.List;
@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private ILibraryRepository libraryRepository;

    @Override
    public BookEntity saveBook(BookRequest bookRequest) {
        BookEntity bookEntity = BookEntity.builder()
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .pages(bookRequest.getPages())
                .year(bookRequest.getYear())
                .coverUrl(bookRequest.getCoverUrl())
                .genre(bookRequest.getGenre())
                .isOwned(bookRequest.getIsOwned())
                .build();
        return libraryRepository.save(bookEntity);
    }

    @Override
    @SneakyThrows
    public BookEntity getBookById(Long id) {
        return libraryRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    @SneakyThrows
    public BookEntity updateBook(Long id, BookRequest bookRequest) {
        BookEntity bookEntity = libraryRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setPages(bookRequest.getPages());
        bookEntity.setYear(bookRequest.getYear());
        bookEntity.setCoverUrl(bookRequest.getCoverUrl());
        bookEntity.setGenre(bookRequest.getGenre());
        bookEntity.setIsOwned(bookRequest.getIsOwned());
        return libraryRepository.save(bookEntity);
    }

    @Override
    public void deleteBookById(Long id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public List<BookEntity> findAllByAuthor(String author) {
        return libraryRepository.findAllByAuthor(author);
    }
    @Override
    public List<BookEntity> findAllByYear(int year) {
        return libraryRepository.findAllByYear(year);
    }

    @Override
    public List<BookEntity> findAllByGenre(String genre) {
        return libraryRepository.findAllByGenre(genre);
    }
}
