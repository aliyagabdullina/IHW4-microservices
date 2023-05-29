package com.example.restaurant;

import model.User;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.sql.SQLException;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody String username,String email,  String password, String role) throws SQLException {
        userService.registerUser(username, email, password, role);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody String username, String password) {
        return userService.login(username, password);
    }

    @GetMapping("/user")
    public User getUserInfo(@RequestHeader("Authorization") String token) {
        return userService.getUserInfo(token);
    }
}

