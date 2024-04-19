package org.example.services;

import org.example.dao.AuthorDAO;
import org.example.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImplementation implements AuthorService{

    @Autowired
    private AuthorDAO authorDAO;
    @Override
    @Transactional
    public List<Author> getAuthors() {
        List<Author> authors = authorDAO.getAuthors();
        return authors;
    }

    @Override
    @Transactional
    public List<Author> getUndeletedAuthors() {
        return authorDAO.getUndeletedAuthors();
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }

    @Override
    @Transactional
    public Author getAuthor(int authorid) {
        return authorDAO.getAuthor(authorid);
    }

    @Override
    @Transactional
    public void deleteAuthor(int authorid) {
        authorDAO.deleteAuthor(authorid);
    }

    @Override
    @Transactional
    public Set<Author> getAuthorsByListOfIds(List<Integer> listOfAuthorsIds) {
       return  authorDAO.getAuthorsByListOfIds(listOfAuthorsIds);
    }
}
