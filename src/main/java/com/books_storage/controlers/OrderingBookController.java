package com.books_storage.controlers;

import com.books_storage.entities.Book;
import com.books_storage.entities.OrderingBook;
import com.books_storage.entities.Reader;
import com.books_storage.entities.Worker;
import com.books_storage.services.BookService;
import com.books_storage.services.OrderingBookService;
import com.books_storage.services.ReaderService;
import com.books_storage.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class OrderingBookController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    private OrderingBookService orderingBookService;

    @ModelAttribute("authUser")
    public Worker globalUserObject(Model model) {
        Long id = getId(SecurityContextHolder.getContext().getAuthentication());
        Worker worker = workerService.getById(id);
        model.addAttribute("worker", worker);
        return worker;
    }

    @GetMapping("/orderingBook")
    public String giveBook(Model model) {
        return "orderingBook";
    }

    @PostMapping("/addOrderingBook")
    public String orderingBook(@RequestParam long idWorker, @RequestParam int numberBook, @RequestParam String numberPhone,
                           @RequestParam int countDay, Model model) {

        Worker worker = workerService.getById(idWorker);
        Book book = bookService.getByNumberBook(numberBook);
        Reader reader = readerService.getByNumberPhone(numberPhone);


        model.addAttribute("worker", worker);
        model.addAttribute("reader", reader);
        model.addAttribute("book", book);
        model.addAttribute("countDay", countDay);
        return "/confirmOrder";
    }

    @PostMapping("/confirm")
    public String confirmOrdering(@RequestParam long idWorker, @RequestParam long idReader, @RequestParam long idBook,
                           @RequestParam int countDay, Model model) {

        Worker worker = workerService.getById(idWorker);
        Reader reader = readerService.getById(idReader);
        Book book = bookService.getById(idBook);
        Date currentDate = Date.valueOf(LocalDate.now());
        Time currentTime = Time.valueOf(LocalTime.now());

        OrderingBook orderingBook = new OrderingBook(worker, reader, book, currentDate, currentTime, countDay);
        reader.addBookToReserveList(book);
        book.addReserveBook();

        orderingBookService.add(orderingBook);
        readerService.edit(reader);
        bookService.edit(book);
        return "/orderingBook";
    }


    private Long getId(Authentication authentication) {
        int start = authentication.getName().indexOf("id=");
        int finish = authentication.getName().indexOf(",");
        String id = authentication.getName().substring(start + 3, finish);
        return Long.valueOf(id);
    }

}
