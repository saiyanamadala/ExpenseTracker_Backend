package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.Users;
import com.expense_tracker.Expense_Tracker_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user){
        return userService.register(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> allUsers(){
        return userService.allUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody Users user){
        System.out.println(user);
        System.out.println(user.getUsername());
        return userService.verify(user);
    }
}
