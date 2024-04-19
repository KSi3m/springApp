package org.example.entity;




import org.example.enums.DeletionStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ksiazki")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "wydawnictwo")
    private String publishing ;

    @Column(name = "cena")
    private Double price;

    @Column(name = "status")
    private String status;

    //@ManyToMany(mappedBy = "ksiazki")
    @ManyToMany()
    @JoinTable(name="autorzy_to_ksiazki",//nazwa tabeli
            joinColumns = @JoinColumn(name="ksiazka_id"), //co laczymy
            inverseJoinColumns = @JoinColumn(name="autor_id") //z czym laczymy
    )
    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="zamowienia_to_ksiazki",//nazwa tabeli
            joinColumns = @JoinColumn(name="ksiazka_id"), //co laczymy
            inverseJoinColumns = @JoinColumn(name="order_id") //z czym laczymy
    )
    private List<Order> orders;

    @ManyToOne(cascade=
            {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "kategoria_id")
    private Category category;


    public Book() {
        this.status = String.valueOf(DeletionStatus.NOT_DELETED);
    }

    public Book(String name, String publishing , Double price) {
        this.name = name;
        this.publishing  = publishing ;
        this.price = price;
    }

    public Book(String name, String publishing , Double price , Category category) {
        this.name = name;
        this.publishing  = publishing;
        this.price = price;
        this.category = category;
    }


    public void addAuthor(Author author){
        if (authors == null)
            authors = new HashSet<>();
        authors.add(author);
    }
    public void deleteAutor(Author author){
        if (authors == null)
            authors = new HashSet<>();
        authors.remove(author);
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

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Integer> getAuthorsIDs()
    {
        List<Integer> authorsIDs = new ArrayList<>();
        for(var author: this.authors)
        {
            authorsIDs.add(author.getId());
        }
        return authorsIDs;
    }

    public List<Integer> getOrdersIDs()
    {
        List<Integer> ordersIDs = new ArrayList<>();
        for(var order: this.orders)
        {
            ordersIDs.add(order.getId());
        }
        return ordersIDs;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", nazwa='" + name + '\'' +
                ", wydawnictwo='" + publishing + '\'' +
                ", cena=" + price +
                '}';
    }
}
