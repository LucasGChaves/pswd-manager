package com.example.app.controller;

import com.example.app.domain.model.User;
import com.example.app.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
