package org.example.controller;


import org.example.cart.Cart;
import org.example.services.BookService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
        private  Cart cart;
    @Autowired
        private  BookService bookService;

    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping
    public String cart(Model model) {
        var books = bookService.getBooksByListOfIds(cart.getBookIds());
        double sum = 0.0;
        for(var book: books)
        {
            sum += book.getPrice();
        }
        model.addAttribute("books",books);

        model.addAttribute("priceOfCart",sum);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam(name = "bookId") int id) {
        cart.addBookId(id);
        return "redirect:/cart";
    }
    @PostMapping("/delete")
    public String removeFromCart(@RequestParam(name = "bookId") int id) {
        cart.deleteBookId(id);
        return "redirect:/cart";
    }


}
