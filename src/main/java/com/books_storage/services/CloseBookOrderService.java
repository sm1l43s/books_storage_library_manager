package com.books_storage.services;

import com.books_storage.entities.CloseBookOrder;

import java.util.List;

public interface CloseBookOrderService {

    void add(CloseBookOrder closeBookOrder);
    void delete(CloseBookOrder closeBookOrder);
    List<CloseBookOrder> getAll();

}
