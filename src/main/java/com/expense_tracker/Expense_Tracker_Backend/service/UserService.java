package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.UserDetails;
import com.expense_tracker.Expense_Tracker_Backend.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    public ResponseEntity<UserDetails> register(UserDetails user) {
        UserDetails savedUser = userDetailsRepo.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    public ResponseEntity<List<UserDetails>> allUsers() {
        return new ResponseEntity<>(userDetailsRepo.findAll(),HttpStatus.OK);
    }
}
