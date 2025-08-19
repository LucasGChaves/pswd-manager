package com.example.app.controller;

import com.example.app.domain.model.User;
import com.example.app.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserByID(id);
    }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
