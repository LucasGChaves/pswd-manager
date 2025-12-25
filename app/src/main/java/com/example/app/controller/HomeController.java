package com.example.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "Welcome to Password Manager!";
    }
}
