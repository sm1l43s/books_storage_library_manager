package com.books_storage.repositories;

import com.books_storage.entities.CloseBookOrder;
import org.springframework.data.repository.CrudRepository;

public interface CloseBookOrderRepository extends CrudRepository<CloseBookOrder, Long> {
}
