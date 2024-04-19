package org.example.services;

import org.example.dao.BookDAO;
import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImplementation implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getBooks() {
        List<Book> books = bookDAO.getBooks();
        return books;
    }

    @Override
    @Transactional
    public List<Book> getUndeletedBooks() {
        return bookDAO.getUndeletedBooks();

    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBook(int bookid) {
        return bookDAO.getBook(bookid);
    }

    @Override
    @Transactional
    public void deleteBook(int bookid) {
        bookDAO.deleteBook(bookid);
    }

    @Override
    @Transactional
    public Set<Book> getBooksByListOfIds(Set<Integer> listOfBooksIds)
    {
        return bookDAO.getBooksByListOfIds(listOfBooksIds);
    }


}
