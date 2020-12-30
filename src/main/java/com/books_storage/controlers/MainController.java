package com.books_storage.controlers;

import com.books_storage.entities.Book;
import com.books_storage.entities.OrderingBook;
import com.books_storage.services.BookService;
import com.books_storage.services.OrderingBookService;
import com.books_storage.services.ReaderService;
import com.books_storage.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private OrderingBookService orderingBookService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private WorkerService workerService;


    @GetMapping("/index")
    public String index(Model model) {

        List<OrderingBook> expiredOrder = orderingBookService.getAllExpiredOrder();

        int totalReader = readerService.getAll().size();
        int totalWorker = workerService.getAll().size();

        List<Book> books = bookService.getAll();
        int totalBooks = 0;
        for (int i = 0; i < books.size(); i++) {
            totalBooks += books.get(i).getTotalCount();
        }

        model.addAttribute("expiredOrder", expiredOrder);
        model.addAttribute("totalReader", totalReader);
        model.addAttribute("totalBooks", totalBooks);
        model.addAttribute("totalWorker", totalWorker);
        return "index";
    }

}
