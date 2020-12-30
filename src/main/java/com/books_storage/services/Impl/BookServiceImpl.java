package com.books_storage.services.Impl;

import com.books_storage.entities.Book;
import com.books_storage.repositories.BookRepository;
import com.books_storage.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void edit(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @Override
    public Book getByNumberBook(int numberBook) {
        Optional<Book> book = bookRepository.findByNumberBook(numberBook);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @Override
    public Book getBookByTitle(String title) {
        Optional<Book> book = bookRepository.findByTitle(title);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @Override
    public List<Book> getAllBookByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }
}
