package org.example.dto;

import org.example.enums.DeletionStatus;

import java.util.Set;

public class AuthorDTO {

    private int id;

    private String name;

    private String surname;
    private String status;

    private Set<Integer> booksIds;

    public AuthorDTO() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Integer> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(Set<Integer> booksIds) {
        this.booksIds = booksIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
