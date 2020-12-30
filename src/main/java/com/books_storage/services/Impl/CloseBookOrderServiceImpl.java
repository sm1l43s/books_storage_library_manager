package com.books_storage.services.Impl;

import com.books_storage.entities.CloseBookOrder;
import com.books_storage.repositories.CloseBookOrderRepository;
import com.books_storage.services.CloseBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CloseBookOrderServiceImpl implements CloseBookOrderService {

    @Autowired
    private CloseBookOrderRepository closeBookOrderRepository;

    @Override
    public void add(CloseBookOrder closeBookOrder) {
        closeBookOrderRepository.save(closeBookOrder);
    }

    @Override
    public void delete(CloseBookOrder closeBookOrder) {
        closeBookOrderRepository.delete(closeBookOrder);
    }

    @Override
    public List<CloseBookOrder> getAll() {
        return (List<CloseBookOrder>) closeBookOrderRepository.findAll();
    }
}

