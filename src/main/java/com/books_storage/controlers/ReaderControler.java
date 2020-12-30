package com.books_storage.controlers;

import com.books_storage.entities.Reader;
import com.books_storage.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReaderControler {

    @Autowired
    private ReaderService readerService;

    @GetMapping("/readerList")
    public String allReaders(Model model) {
        List<Reader> allReaders = readerService.getAll();
        model.addAttribute("allReaders", allReaders);
        return "readerList";
    }

    @GetMapping("/readerList/add")
    public String addReader(Model model) {
        return "addReader";
    }

    @PostMapping("/addReader")
    public String addReader(@RequestParam String lastName, @RequestParam String firstName, @RequestParam String patronym,
                          @RequestParam String numberPhone, Model model) {
        Reader reader = new Reader(lastName, firstName, patronym, numberPhone);
        readerService.add(reader);
        return "redirect:/readerList";
    }

    @GetMapping("/readerList/remove/{id}")
    public String removeReader(@PathVariable(value = "id") long id, Model model) {
        Reader reader = readerService.getById(id);
        readerService.delete(reader);
        return "redirect:/readerList";
    }

    @GetMapping("/readerList/edit/{id}")
    public String editReader(@PathVariable(value = "id") long id, Model model) {
        Reader reader = readerService.getById(id);
        model.addAttribute("reader", reader);
        return "/editReader";
    }

    @PostMapping("/editReader")
    public String editReader(@RequestParam long id, @RequestParam String lastName, @RequestParam String firstName,
                           @RequestParam String patronym, @RequestParam String numberPhone, Model model) {
        Reader reader = readerService.getById(id);
        reader.setLastName(lastName);
        reader.setFirstName(firstName);
        reader.setPatronym(patronym);
        reader.setNumberPhone(numberPhone);
        readerService.edit(reader);
        return "redirect:/readerList";
    }

    @GetMapping("/readerList/moreInfo/{id}")
    public String moreInfoReader(@PathVariable(value = "id") long id, Model model) {
        Reader reader = readerService.getById(id);
        model.addAttribute("reader", reader);
        return "/moreInfoReader";
    }

}
