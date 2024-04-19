package org.example.dao;

import org.example.entity.Author;

import java.util.List;
import java.util.Set;

public interface AuthorDAO {
    public List<Author> getAuthors();
    public void saveAuthor(Author author);
    public Author getAuthor(int authorid);
    public void deleteAuthor(int authorid);
    public Set<Author> getAuthorsByListOfIds(List<Integer> listOfAuthorsIds);

    List<Author> getUndeletedAuthors();
}
