package com.books_storage.services;

import com.books_storage.entities.Book;
import com.books_storage.entities.OrderingBook;
import com.books_storage.entities.Reader;

import java.util.List;

public interface OrderingBookService {
    void add(OrderingBook orderingBook);
    void edit(OrderingBook orderingBook);
    void delete(OrderingBook orderingBook);
    OrderingBook getById(long id);
    OrderingBook getByReaderAndBook(Reader reader, Book book);
    List<OrderingBook> getAllStatusOrder(String status);
    List<OrderingBook> getAllExpiredOrder();
    List<OrderingBook> getAll();
}
