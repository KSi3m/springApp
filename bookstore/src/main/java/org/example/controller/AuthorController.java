package org.example.controller;

import org.example.dto.AuthorDTO;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.services.AuthorService;
import org.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String listAuthors(Model model) {
        List<Author> authors = authorService.getUndeletedAuthors();
        model.addAttribute("authors", authors);
        return "authorslist";
    }
    @GetMapping("/add")
    public String addForm(Model model)
    {
        AuthorDTO authorDTO = new AuthorDTO();
        model.addAttribute("authorDTO",authorDTO);
        return "addauthorform";
    }
    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("authorDTO") AuthorDTO authorDTO)
    {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setStatus(authorDTO.getStatus());
        Set<Book> books = bookService.getBooksByListOfIds(authorDTO.getBooksIds());
        author.setBooks(books);
        authorService.saveAuthor(author);
        return "redirect:/authors/list";
    }
    @GetMapping("/updateAuthorForm")
    public String updateAuthorForm(@RequestParam("authorId")int authorId, Model model){
        Author author = authorService.getAuthor(authorId);
        AuthorDTO authorDTO = new AuthorDTO();

        if(author != null)
        {
            authorDTO.setId(author.getId());
            authorDTO.setName(author.getName());
            authorDTO.setSurname(author.getSurname());
            authorDTO.setBooksIds(author.getBooksIds());
            authorDTO.setStatus(author.getStatus());
        }
        model.addAttribute("authorDTO",authorDTO);
        return "addauthorform";
    }
    @GetMapping("/deleteAuthorForm")
    public String deleteAuthorForm(@RequestParam("authorId")int authorId, Model model){
        Author author = authorService.getAuthor(authorId);
        model.addAttribute("author",author);
        return "deleteauthorform";

    }

    @PostMapping("/deleteAuthor")
    public String deleteAuthor(@ModelAttribute("author") Author author){
        authorService.deleteAuthor(author.getId());
        return "redirect:/authors/list";
    }
}
