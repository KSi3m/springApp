package org.example.entity;


import org.example.enums.DeletionStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="autorzy")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name="autor_id"),
            inverseJoinColumns = @JoinColumn(name="ksiazka_id")
    )
    private Set<Book> books;

    public Author() {
        this.status = String.valueOf(DeletionStatus.NOT_DELETED);
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addBook(Book book) {
        if (books == null) {
            books = new HashSet<>();
        }
        books.add(book);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Integer> getBooksIds()
    {
        Set<Integer> booksIds = new HashSet<>();
        for(var book: this.books)
        {
            booksIds.add(book.getId());
        }
        return booksIds;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", imie='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                '}';
    }
}
