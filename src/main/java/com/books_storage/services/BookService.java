package com.books_storage.services;

import com.books_storage.entities.Book;

import java.util.List;

public interface BookService {

    void add(Book book);
    void delete(Book book);
    void edit(Book book);
    Book getById(long id);
    Book getByNumberBook(int numberBook);
    Book getBookByTitle(String title);
    List<Book> getAllBookByAuthor(String author);
    List<Book> getAll();

}
