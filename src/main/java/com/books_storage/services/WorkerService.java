package com.books_storage.services;

import com.books_storage.entities.Worker;

import java.util.List;

public interface WorkerService {
    void add(Worker worker);
    void delete(Worker worker);
    void edit(Worker worker);
    Worker getById(long id);
    Worker getByLastNameAndFirstName(String lastName, String firstName);
    List<Worker> getAll();
}
