package org.nye.progkorny;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.nye.progkorny.entity.BookEntity;
import org.nye.progkorny.repository.ILibraryRepository;
import org.nye.progkorny.request.BookRequest;
import org.nye.progkorny.service.LibraryService;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private ILibraryRepository libraryRepository;

    @InjectMocks
    private LibraryService libraryService;

    private BookRequest bookRequest;
    private BookEntity bookEntity;

    @BeforeEach
    public void setUp() {
        bookRequest = BookRequest.builder()
                .author("Author")
                .title("title")
                .pages(123)
                .publicationYear(2024)
                .coverUrl("coverUrl")
                .genre("genre")
                .isOwned(true)
                .build();

        bookEntity = BookEntity.builder()
                .id(1L)
                .author("Author")
                .title("title")
                .pages(123)
                .publicationYear(2024)
                .coverUrl("coverUrl")
                .genre("genre")
                .isOwned(true)
                .build();
    }

    @Test
    public void testSaveBook() {
        when(libraryRepository.save(any(BookEntity.class))).thenReturn(bookEntity);

        BookEntity savedBook = libraryService.saveBook(bookRequest);

        assertNotNull(savedBook);
        assertEquals(bookEntity.getAuthor(), savedBook.getAuthor());
        assertEquals(bookEntity.getTitle(), savedBook.getTitle());
        assertEquals(bookEntity.getPages(), savedBook.getPages());
        assertEquals(bookEntity.getPublicationYear(), savedBook.getPublicationYear());
        assertEquals(bookEntity.getCoverUrl(), savedBook.getCoverUrl());
        assertEquals(bookEntity.getGenre(), savedBook.getGenre());
        assertEquals(bookEntity.getIsOwned(), savedBook.getIsOwned());

        verify(libraryRepository, times(1)).save(any(BookEntity.class));
    }

    @Test
    public void testFindAllBooks() {
        List<BookEntity> bookList = Arrays.asList(bookEntity);
        when(libraryRepository.findAll()).thenReturn(bookList);

        List<BookEntity> result = libraryService.getAllBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(bookEntity.getTitle(), result.get(0).getTitle());

        verify(libraryRepository, times(1)).findAll();

    }

    @Test
    public void testGetBookById() {
        when(libraryRepository.findById(1L)).thenReturn(Optional.of(bookEntity));

        Optional<BookEntity> foundBook = Optional.ofNullable(libraryService.getBookById(1L));

        assertTrue(foundBook.isPresent());
        assertEquals(bookEntity.getTitle(), foundBook.get().getTitle());

        verify(libraryRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteBook() {
        doNothing().when(libraryRepository).deleteById(1L);

        libraryService.deleteBookById(1L);

        verify(libraryRepository, times(1)).deleteById(1L);
    }
}
