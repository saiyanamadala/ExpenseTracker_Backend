package com.expense_tracker.Expense_Tracker_Backend.repository;

import com.expense_tracker.Expense_Tracker_Backend.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepo extends MongoRepository<Users,Integer> {
    Users findByUsername(String username);
}
