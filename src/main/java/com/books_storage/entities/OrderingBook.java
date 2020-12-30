package com.books_storage.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class OrderingBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Worker worker;

    @OneToOne
    private Reader reader;

    @OneToOne
    private Book book;

    @Column(name = "date_order")
    private Date dateOrder;

    @Column(name = "time_order")
    private Time timeOrder;

    private int countDayOrder;

    private String status;

    public OrderingBook() {}

    public OrderingBook(Worker worker, Reader reader, Book book, Date dateOrder, Time timeOrder, int countDayOrder) {
        this.worker = worker;
        this.reader = reader;
        this.book = book;
        this.dateOrder = dateOrder;
        this.timeOrder = timeOrder;
        this.countDayOrder = countDayOrder;
        this.status = "активный";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Time getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Time timeOrder) {
        this.timeOrder = timeOrder;
    }

    public int getCountDayOrder() {
        return countDayOrder;
    }

    public void setCountDayOrder(int countDayOrder) {
        this.countDayOrder = countDayOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
