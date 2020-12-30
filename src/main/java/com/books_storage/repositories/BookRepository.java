package com.books_storage.repositories;

import com.books_storage.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByNumberBook(int numberBook);
    List<Book> findAllByAuthor(String author);
    Optional<Book> findByTitle(String title);

}
