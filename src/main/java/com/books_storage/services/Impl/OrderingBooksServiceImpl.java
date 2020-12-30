package com.books_storage.services.Impl;

import com.books_storage.entities.Book;
import com.books_storage.entities.OrderingBook;
import com.books_storage.entities.Reader;
import com.books_storage.repositories.OrderingBookRepository;
import com.books_storage.services.OrderingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderingBooksServiceImpl implements OrderingBookService {

    @Autowired
    private OrderingBookRepository orderingBookRepository;

    @Override
    public void add(OrderingBook orderingBook) {
        orderingBookRepository.save(orderingBook);
    }

    @Override
    public void edit(OrderingBook orderingBook) {
        orderingBookRepository.save(orderingBook);
    }

    @Override
    public void delete(OrderingBook orderingBook) {
        orderingBookRepository.delete(orderingBook);
    }

    @Override
    public OrderingBook getById(long id) {
        Optional<OrderingBook> orderingBook = orderingBookRepository.findById(id);
        if (orderingBook.isPresent()) {
            return orderingBook.get();
        }
        return null;
    }

    @Override
    public OrderingBook getByReaderAndBook(Reader reader, Book book) {
        Optional<OrderingBook> orderingBook = orderingBookRepository.findByReaderAndBook(reader, book);
        if (orderingBook.isPresent()) {
            return orderingBook.get();
        }
        return null;
    }

    @Override
    public List<OrderingBook> getAllStatusOrder(String status) {
        return orderingBookRepository.findAllByStatus(status);
    }

    @Override
    public List<OrderingBook> getAllExpiredOrder() {
        return (List<OrderingBook>) orderingBookRepository.findByAllExpiredOrder();
    }

    @Override
    public List<OrderingBook> getAll() {
        return (List<OrderingBook>) orderingBookRepository.findAll();
    }
}
