package org.example.dao;

import org.example.entity.Author;
import org.example.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    public List<Book> getBooks();
    public void saveBook(Book book);
    public Book getBook(int bookid);
    public void deleteBook(int bookid);

    public Set<Book> getBooksByListOfIds(Set<Integer> listOfBooksIds);

    public List<Book> getUndeletedBooks();
}