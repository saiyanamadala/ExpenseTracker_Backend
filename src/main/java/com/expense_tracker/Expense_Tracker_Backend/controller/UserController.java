package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.UserDetails;
import com.expense_tracker.Expense_Tracker_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDetails> register(@RequestBody UserDetails user){
        return userService.register(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDetails>> allUsers(){
        return userService.allUsers();
    }
}
