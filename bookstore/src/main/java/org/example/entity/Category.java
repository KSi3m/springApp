package org.example.entity;


import org.example.enums.DeletionStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="kategorie")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "category",
            orphanRemoval = true,
            cascade=CascadeType.ALL)
    List<Book> books;

    public Category() {
        this.status = String.valueOf(DeletionStatus.NOT_DELETED);
    }

    public Category(String name) {
        this.name = name;
    }

    public void addTitle(Book book) {
        if (books == null)
            books = new ArrayList<>();
        book.setCategory(this);
        books.add(book);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
