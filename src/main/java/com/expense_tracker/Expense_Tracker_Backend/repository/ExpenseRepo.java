package com.expense_tracker.Expense_Tracker_Backend.repository;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepo extends MongoRepository<Expense, UUID> {
    List<Expense> findAllByUid(String uid);
}
