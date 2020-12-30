package com.books_storage.services.Impl;

import com.books_storage.entities.Reader;
import com.books_storage.repositories.ReaderRepository;
import com.books_storage.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public void add(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public void delete(Reader reader) {
        readerRepository.delete(reader);
    }

    @Override
    public void edit(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public Reader getById(long id) {
        Optional<Reader> reader = readerRepository.findById(id);
        if (reader.isPresent()) {
            return reader.get();
        }
        return null;
    }

    @Override
    public Reader getByNumberPhone(String numberPhone) {
        Optional<Reader> reader = readerRepository.findByNumberPhone(numberPhone);
        if (reader.isPresent()) {
            return reader.get();
        }
        return null;
    }

    @Override
    public List<Reader> getAll() {
        return (List<Reader>) readerRepository.findAll();
    }
}
