package com.example.Praktikum6.controller;

import com.example.Praktikum6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Data bersifat temporary
    private List<User> userList = new ArrayList<>();

    // Tambahan agar localhost:8080 langsung diarahkan ke halaman login
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Password sesuaikan dengan NIM kamu
        // Gunakan NIM kamu sebagai password (contoh: 20210140001)
        if ("admin".equals(username) && "20210140001".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password salah!");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute User user) {
        userList.add(user);
        return "redirect:/home";
    }
}