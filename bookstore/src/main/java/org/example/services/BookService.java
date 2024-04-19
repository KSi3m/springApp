package org.example.services;

import org.example.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookService {
    List<Book> getBooks();
    public List<Book> getUndeletedBooks();
    public void saveBook(Book book);
    Book getBook(int bookid);
    public void deleteBook(int bookid);
    public Set<Book> getBooksByListOfIds(Set<Integer> listOfBooksIds);
}
