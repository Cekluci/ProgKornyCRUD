package org.nye.progkorny.repository;

import org.nye.progkorny.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ILibraryRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAllByAuthor(String author);

    List<BookEntity> findAllByYear(int year);

    List<BookEntity> findAllByGenre(String genre);
}
