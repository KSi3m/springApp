package org.example.services;

import org.example.entity.Author;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    List<Author> getAuthors();
    List<Author> getUndeletedAuthors();
    public void saveAuthor(Author author);
    public Author getAuthor(int authorid);
    public void deleteAuthor(int authorid);
    public Set<Author> getAuthorsByListOfIds(List<Integer> listOfAuthorsIds);
}
