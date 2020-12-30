package com.books_storage.controlers;

import com.books_storage.entities.Reader;
import com.books_storage.entities.Worker;
import com.books_storage.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workerService;



    @GetMapping("/worker")
    public String allWorkers(Model model) {
        model.addAttribute("allWorkers", workerService.getAll());
        return "worker";
    }

    @GetMapping("/worker/remove/{id}")
    public String removeReader(@PathVariable(value = "id") long id, Model model) {
        Worker worker = workerService.getById(id);
        workerService.delete(worker);
        return "redirect:/worker";
    }

}
