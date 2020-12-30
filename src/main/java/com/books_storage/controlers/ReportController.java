package com.books_storage.controlers;

import com.books_storage.entities.CloseBookOrder;
import com.books_storage.entities.OrderingBook;
import com.books_storage.services.CloseBookOrderService;
import com.books_storage.services.OrderingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private OrderingBookService orderingBookService;

    @Autowired
    private CloseBookOrderService closeBookOrderService;

    @GetMapping("/report")
    public String report(Model model) {
        List<OrderingBook> orderingBookList = orderingBookService.getAllStatusOrder("активный");

        Collections.reverse(orderingBookList);
        if (orderingBookList.size() > 10) {
            orderingBookList = orderingBookList.subList(0, 9);
        }

        List<CloseBookOrder> closeBookOrderList = closeBookOrderService.getAll();
        Collections.reverse(closeBookOrderList);
        if (closeBookOrderList.size() > 10) {
            closeBookOrderList = closeBookOrderList.subList(0, 9);
        }

        model.addAttribute("orderList", orderingBookList);
        model.addAttribute("closeOrderList", closeBookOrderList);
        return "report";
    }

    @GetMapping("/allOrderingBook")
    public String allReportOrderingBook(Model model) {
        model.addAttribute("ordering", orderingBookService.getAll());
        return "allOrderingBook";
    }

    @GetMapping("/allCloseOrdering")
    public String allReportCloseOrderingBook(Model model) {
        model.addAttribute("closeOrderList", closeBookOrderService.getAll());
        return "allCloseOrdering";
    }

}
