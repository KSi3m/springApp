package org.example.controller;


import com.ctc.wstx.exc.WstxOutputException;
import org.example.dto.BookDTO;
import org.example.entity.Author;
import org.example.entity.Category;
import org.example.entity.Book;
import org.example.entity.Order;
import org.example.services.AuthorService;
import org.example.services.BookService;
import org.example.services.CategoryService;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private OrderService orderService;


    @GetMapping("/list")
    public String listBook(Model model) {
        List<Book> books = bookService.getUndeletedBooks();
        model.addAttribute("books", books);
        return "bookslist";
    }

    @GetMapping("/formadd")
    public String addForm(Model model)
    {
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("bookDTO",bookDTO);
        List<Category> categories = categoryService.getUndeletedCategories();
        model.addAttribute("categories", categories);
        List<Author> authors = authorService.getUndeletedAuthors();
        model.addAttribute("authors", authors);
        return "addbookform";
    }
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("bookDTO") BookDTO bookDTO)
    {

        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setPublishing(bookDTO.getPublishing());
        book.setPrice((double) bookDTO.getPrice());
        book.setStatus(bookDTO.getStatus());

        Category category = categoryService.getCategory(bookDTO.getCategoryid());
        book.setCategory(category);

        Set<Author> authors = authorService.getAuthorsByListOfIds(bookDTO.getAuthorsIds());
        book.setAuthors(authors);

        if (bookDTO.getOrdersIds().isEmpty()) {
            book.setOrders(new ArrayList<>());
        }
        else {
            List<Order> orders = orderService.getOrdersByListOfIds(bookDTO.getOrdersIds());
            book.setOrders(orders);
        }

        bookService.saveBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/updateBookForm")
    public String updateBookForm(@RequestParam("bookId")int bookid, Model model){
        Book book = bookService.getBook(bookid);
        BookDTO bookDTO = new BookDTO();
        if(book != null)
        {
            bookDTO.setId(book.getId());
            bookDTO.setPrice(book.getPrice());
            bookDTO.setCategoryid(book.getCategory().getId());
            bookDTO.setName(book.getName());
            bookDTO.setPublishing(book.getPublishing());
            bookDTO.setAuthorsIds(book.getAuthorsIDs());
            bookDTO.setStatus(book.getStatus());
            bookDTO.setOrdersIds(book.getOrdersIDs());
        }
        model.addAttribute("bookDTO",bookDTO);
        List<Category> categories = categoryService.getUndeletedCategories();
        model.addAttribute("categories", categories);
        List<Author> authors = authorService.getUndeletedAuthors();
        model.addAttribute("authors", authors);
        List<Order> orders = book.getOrders();
        model.addAttribute("orders", orders);

        return "addbookform";
    }
    @GetMapping("/deleteBookForm")
    public String deleteBookForm(@RequestParam("bookId")int bookid, Model model){
        Book book = bookService.getBook(bookid);
        model.addAttribute("book",book);
        return "deletebookform";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@ModelAttribute("book") Book book){
        bookService.deleteBook(book.getId());
        return "redirect:/books/list";
    }


}
