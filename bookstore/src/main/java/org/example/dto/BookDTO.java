package org.example.dto;

import org.example.entity.Order;
import org.example.enums.DeletionStatus;

import java.util.List;

public class BookDTO {
    private int id;
    private String name;
    private String publishing;
    private double price;
    private int categoryid;
    private String status;
    private List<Integer> authorsIds;

    private List<Integer> ordersIds;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookDTO() {
        this.status = String.valueOf(DeletionStatus.NOT_DELETED);
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public List<Integer> getAuthorsIds() {
        return authorsIds;
    }

    public void setAuthorsIds(List<Integer> authorsIds) {
        this.authorsIds = authorsIds;
    }

    public List<Integer> getOrdersIds() {
        return ordersIds;
    }

    public void setOrdersIds(List<Integer> ordersIds) {
        this.ordersIds = ordersIds;
    }
}