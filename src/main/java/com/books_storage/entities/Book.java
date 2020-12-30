package com.books_storage.entities;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_book")
    private int numberBook;

    private String author;
    private String title;
    private int totalCount;

    private int reserveCount;


    public Book() {}

    public Book(int numberBook, String author, String title, int totalCount) {
        this.numberBook = numberBook;
        this.author = author;
        this.title = title;
        this.totalCount = totalCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getReserveCount() {
        return reserveCount;
    }

    public void setReserveCount(int reserveCount) {
        this.reserveCount = reserveCount;
    }

    public int getActualCountBook() {
        return getTotalCount() - getReserveCount();
    }

    public void addReserveBook() {
        this.reserveCount = getReserveCount() + 1;
    }

    public void subtractReserveBook() {
        this.reserveCount = getReserveCount() - 1;
    }
}
