package com.books_storage.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, name = "last_name")
    private String lastName;

    @Column(length = 100, name = "first_name")
    private String firstName;

    private String patronym;

    @Column(name = "number_phone", length = 50)
    private String numberPhone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> allBooks;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> reserveBooks;

    public Reader() {}

    public Reader(String lastName, String firstName, String patronym, String numberPhone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronym = patronym;
        this.numberPhone = numberPhone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void addBookToAllList(Book book) {
        this.getAllBooks().add(book);
    }

    public Set<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(Set<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public void addBookToReserveList(Book book) {
        this.getReserveBooks().add(book);
    }

    public void removeBookFromReserveList(Book book) {
        this.getReserveBooks().remove(book);
    }

    public Set<Book> getReserveBooks() {
        return reserveBooks;
    }

    public void setReserveBooks(Set<Book> reserveBooks) {
        this.reserveBooks = reserveBooks;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronym='" + patronym + '\'' +
                ", numberPhone=" + numberPhone +
                ", allBooks=" + allBooks +
                ", reserveBooks=" + reserveBooks +
                '}';
    }
}
