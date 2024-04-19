package org.example.entity;


import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String status;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @ManyToOne(cascade=
            {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private User user;

    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="zamowienia_to_ksiazki",//nazwa tabeli
            joinColumns = @JoinColumn(name="order_id"), //co laczymy
            inverseJoinColumns = @JoinColumn(name="ksiazka_id") //z czym laczymy
    )
    private Set<Book> books;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /*public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }*/
}
