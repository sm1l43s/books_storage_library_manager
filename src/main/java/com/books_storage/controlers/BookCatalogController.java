package com.books_storage.controlers;

import com.books_storage.entities.Book;
import com.books_storage.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookCatalogController {

    @Autowired
    private BookService bookService;

    @GetMapping("/bookCatalog")
    public String giveBook(Model model) {
        List<Book> allBooks = bookService.getAll();
        model.addAttribute("allBooks", allBooks);
        return "bookCatalog";
    }

    @GetMapping("/bookCatalog/add")
    public String addBook(Model model) {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam int numberBook, @RequestParam String author, @RequestParam String title,
                               @RequestParam int countBook, Model model) {
        Book book = new Book(numberBook, author, title, countBook);
        bookService.add(book);
        return "redirect:/bookCatalog";
    }

    @GetMapping("/bookCatalog/remove/{id}")
    public String removeBook(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getById(id);
        bookService.delete(book);
        return "redirect:/bookCatalog";
    }

    @GetMapping("/bookCatalog/edit/{id}")
    public String editBook(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "/editBook";
    }

    @PostMapping("/editBook")
    public String editBook(@RequestParam long id, @RequestParam int numberBook, @RequestParam String author,
                           @RequestParam String title, @RequestParam int countBook, Model model) {
        Book book = bookService.getById(id);
        book.setNumberBook(numberBook);
        book.setAuthor(author);
        book.setTitle(title);
        book.setTotalCount(countBook);
        bookService.edit(book);
        return "redirect:/bookCatalog";
    }

}
