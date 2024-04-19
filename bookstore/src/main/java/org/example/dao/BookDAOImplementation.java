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
public class BookDAOImplementation implements BookDAO {
    //automatyczne wykorzystanie beana sessionFactory
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Book> getBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("SELECT DISTINCT b from Book as b LEFT JOIN FETCH b.authors", Book.class);
        List<Book> books = query.getResultList();
        return books ;
    }
    @Override
//zapis ksiazki do bazy:
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        //Kategoria kategoria = ksiazka.getKategoria();
       // kategoria.setId(Integer.parseInt(kategoria.getNazwa()));
        session.saveOrUpdate(book);
    }
    @Override
    public Book getBook(int bookid) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b from Book as b LEFT JOIN FETCH b.authors where b.id='"+bookid+"'", Book.class);
        List<Book> books = query.getResultList();
        return books.get(0);
    }

    @Override
    public void deleteBook(int bookid) {
        Session session = sessionFactory.getCurrentSession();
        var book = session.get(Book.class,bookid);
        book.setStatus(String.valueOf(DeletionStatus.DELETED));
        session.update(book);
        //session.delete(book);
    }


    @Override
    public Set<Book> getBooksByListOfIds(Set<Integer> listOfBooksIds) {

        Session session = sessionFactory.getCurrentSession();
        if (listOfBooksIds.isEmpty()) return new HashSet<>();
        Query<Book> query = session.createQuery("SELECT DISTINCT b from Book as b LEFT JOIN FETCH b.authors where b.id IN (:listOfBooksIds)", Book.class).setParameterList("listOfBooksIds",listOfBooksIds);
        Set<Book> books = query.getResultStream().collect(Collectors.toSet());
        return books;

    }
    @Override
    public List<Book> getUndeletedBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("SELECT DISTINCT b from Book as b LEFT JOIN FETCH b.authors WHERE b.status = '"+String.valueOf(DeletionStatus.NOT_DELETED)+"'", Book.class);
        List<Book> books = query.getResultList();
        return books ;
    }

}