package com.books_storage.controlers;

import com.books_storage.entities.Worker;
import com.books_storage.services.RoleService;
import com.books_storage.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String login(@RequestParam(name = "message", required = false) Boolean message, Model model) {
        if (message != null) {
            if (message) {
                model.addAttribute("logout", true);
            } else {
                model.addAttribute("signError", true);
            }
        }
        return "login";
    }

    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String lastName, @RequestParam String firstName, @RequestParam String patronym,
                               @RequestParam String password, Model model) {

        Worker worker = new Worker(firstName, lastName, patronym, passwordEncoder.encode(password));
        worker.setRole(roleService.getByName("USER"));
        workerService.add(worker);
        return "redirect:/worker";
    }

}
