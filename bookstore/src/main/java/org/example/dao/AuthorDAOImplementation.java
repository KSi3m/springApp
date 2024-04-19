package org.example.dao;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.enums.DeletionStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class AuthorDAOImplementation implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Author> getAuthors() {
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Author> query = currentSession.createQuery("SELECT DISTINCT a from Author as a LEFT JOIN FETCH a.books", Author.class);
        List<Author> authors = query.getResultList();
        return authors ;
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public Author getAuthor(int authorid) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT DISTINCT a from Author as a LEFT JOIN FETCH a.books where a.id='"+authorid+"'";
        Query<Author> query = session.createQuery(hql, Author.class);
        List<Author> authors = query.getResultList();
        return authors.get(0);
    }

    @Override
    public void deleteAuthor(int authorid) {
        Session session = sessionFactory.getCurrentSession();
        var author = session.get(Author.class,authorid);
        author.setStatus(String.valueOf(DeletionStatus.DELETED));
        session.update(author);
    }

    @Override
    public Set<Author> getAuthorsByListOfIds(List<Integer> listOfAuthorsIds) {

        /*Set<Author> authors = new HashSet<>();
        for (var authorID : listOfAuthorsIds)
        {
            var author = getAuthor(authorID);
            authors.add(author);
        }
        return authors;*/
        Session session = sessionFactory.getCurrentSession();
        if (listOfAuthorsIds.isEmpty()) return new HashSet<>();

        String hqlQuery = "SELECT DISTINCT a from Author as a LEFT JOIN FETCH a.books where a.id IN (:listOfAuthorsIds)";
        Query<Author> query = session.createQuery(hqlQuery, Author.class).setParameterList("listOfAuthorsIds",listOfAuthorsIds);
        Set<Author> authors = query.getResultStream().collect(Collectors.toSet());
        return authors;
    }

    @Override
    public List<Author> getUndeletedAuthors() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Author> query = currentSession.createQuery("SELECT DISTINCT a from Author as a LEFT JOIN FETCH a.books WHERE a.status = '"+String.valueOf(DeletionStatus.NOT_DELETED)+"'", Author.class);
        List<Author> authors = query.getResultList();
        return authors ;
    }
}
