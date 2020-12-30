package com.books_storage.repositories;

import com.books_storage.entities.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Optional<Worker> findById(long id);
    Optional<Worker> findByLastNameAndFirstName(String lastName, String firstName);
}
