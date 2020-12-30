package com.books_storage.repositories;

import com.books_storage.entities.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReaderRepository extends CrudRepository<Reader, Long> {

    Optional<Reader> findByNumberPhone(String numberPhone);

}
