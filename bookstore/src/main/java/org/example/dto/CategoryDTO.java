package org.example.dto;

import org.example.enums.DeletionStatus;

import javax.persistence.Column;
import java.util.List;

public class CategoryDTO {

    private int id;

    private String name;

    List<Integer> booksIds;

    private String status;

    public CategoryDTO() {
        this.status = String.valueOf(DeletionStatus.NOT_DELETED);
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

    public List<Integer> getBooksIds() {
        return booksIds;
    }

    public void setBooksIdsIds(List<Integer> booksIds) {
        this.booksIds = booksIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
