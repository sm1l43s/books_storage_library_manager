package com.books_storage.services;

import com.books_storage.entities.Reader;

import java.util.List;

public interface ReaderService {

    void add(Reader reader);
    void delete(Reader reader);
    void edit(Reader reader);
    Reader getById(long id);
    Reader getByNumberPhone(String numberPhone);
    List<Reader> getAll();

}
