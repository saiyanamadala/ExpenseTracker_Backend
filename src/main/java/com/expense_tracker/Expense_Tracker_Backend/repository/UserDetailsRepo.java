package com.expense_tracker.Expense_Tracker_Backend.repository;

import com.expense_tracker.Expense_Tracker_Backend.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepo extends MongoRepository<UserDetails,Integer> {
}
