package org.example.dto;

import org.example.entity.Book;
import org.example.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

public class OrderDTO {
    private int id;

    public OrderDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
