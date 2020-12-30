package com.books_storage.services.Impl;

import com.books_storage.entities.Worker;
import com.books_storage.repositories.WorkerRepository;
import com.books_storage.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    @Transactional
    public void add(Worker worker) {
        workerRepository.save(worker);
    }

    @Override
    @Transactional
    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }

    @Override
    @Transactional
    public void edit(Worker worker) {
        workerRepository.save(worker);
    }

    @Override
    @Transactional
    public Worker getById(long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isPresent()) {
            return worker.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Worker getByLastNameAndFirstName(String lastName, String firstName) {
        Optional<Worker> worker = workerRepository.findByLastNameAndFirstName(lastName, firstName);
        if (worker.isPresent()) {
            return worker.get();
        }
        return null;
    }

    @Override
    @Transactional
    public List<Worker> getAll() {
        return (List<Worker>) workerRepository.findAll();
    }
}
