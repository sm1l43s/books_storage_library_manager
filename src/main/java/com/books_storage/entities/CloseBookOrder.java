package com.books_storage.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class CloseBookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private OrderingBook orderingBook;

    @OneToOne
    private Worker worker;

    private Date dateCloseOrder;

    public CloseBookOrder() {}

    public CloseBookOrder(OrderingBook orderingBook, Worker worker, Date dateCloseOrder) {
        this.orderingBook = orderingBook;
        this.worker = worker;
        this.dateCloseOrder = dateCloseOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderingBook getOrderingBook() {
        return orderingBook;
    }

    public void setOrderingBook(OrderingBook orderingBook) {
        this.orderingBook = orderingBook;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getDateCloseOrder() {
        return dateCloseOrder;
    }

    public void setDateCloseOrder(Date dateCloseOrder) {
        this.dateCloseOrder = dateCloseOrder;
    }
}
