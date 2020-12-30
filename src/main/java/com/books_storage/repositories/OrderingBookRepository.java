package com.books_storage.repositories;

import com.books_storage.entities.Book;
import com.books_storage.entities.OrderingBook;
import com.books_storage.entities.Reader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderingBookRepository extends CrudRepository<OrderingBook, Long> {

    String GET_ALL_EXPIRED_ORDER = "SELECT * FROM books_storage.ordering_book WHERE CURRENT_DATE() > ordering_book.date_order" +
            " AND adddate(ordering_book.date_order, ordering_book.count_day_order) AND ordering_book.status = 'активный'";

    Optional<OrderingBook> findByReaderAndBook(Reader reader, Book book);

    @Query(
            value = GET_ALL_EXPIRED_ORDER,
            nativeQuery = true)
    List<OrderingBook> findByAllExpiredOrder();
    List<OrderingBook> findAllByStatus(String status);
}
