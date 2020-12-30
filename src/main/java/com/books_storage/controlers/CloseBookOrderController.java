package com.books_storage.controlers;

import com.books_storage.entities.*;
import com.books_storage.services.*;
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
import java.time.LocalDate;

@Controller
public class CloseBookOrderController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @Autowired
    private OrderingBookService orderingBookService;

    @Autowired
    private CloseBookOrderService closeBookOrderService;

    @ModelAttribute("authUser")
    public Worker globalUserObject(Model model) {
        Long id = getId(SecurityContextHolder.getContext().getAuthentication());
        Worker worker = workerService.getById(id);
        model.addAttribute("worker", worker);
        return worker;
    }

    @GetMapping("/closeBookOrder")
    public String closeBookOrder(Model model) {
        return "closeBookOrder";
    }

    private Long getId(Authentication authentication) {
        int start = authentication.getName().indexOf("id=");
        int finish = authentication.getName().indexOf(",");
        String id = authentication.getName().substring(start + 3, finish);
        return Long.valueOf(id);
    }

    @PostMapping("/closeBookOrder")
    public String orderingBook(@RequestParam long idWorker, @RequestParam int numberBook,
                               @RequestParam String numberPhone, Model model) {

        Worker worker = workerService.getById(idWorker);
        Book book = bookService.getByNumberBook(numberBook);
        Reader reader = readerService.getByNumberPhone(numberPhone);
        OrderingBook orderingBook = orderingBookService.getByReaderAndBook(reader, book);

        model.addAttribute("worker", worker);
        model.addAttribute("order", orderingBook);
        return "/confirmCloseOrder";
    }

    @PostMapping("/confirmCloseOrder")
    public String confirmOrdering(@RequestParam long idWorker, @RequestParam long idOrder, Model model) {

        Worker worker = workerService.getById(idWorker);
        OrderingBook orderingBook = orderingBookService.getById(idOrder);
        Reader reader = readerService.getById(orderingBook.getReader().getId());
        Book book = bookService.getById(orderingBook.getBook().getId());
        Date currentDate = Date.valueOf(LocalDate.now());

        CloseBookOrder closeBookOrder = new CloseBookOrder(orderingBook, worker, currentDate);
        closeBookOrderService.add(closeBookOrder);

        orderingBook.setStatus("закрыт");
        orderingBookService.edit(orderingBook);

        reader.removeBookFromReserveList(book);
        reader.addBookToAllList(book);
        readerService.edit(reader);

        book.subtractReserveBook();
        bookService.edit(book);

        return "/closeBookOrder";
    }

}
