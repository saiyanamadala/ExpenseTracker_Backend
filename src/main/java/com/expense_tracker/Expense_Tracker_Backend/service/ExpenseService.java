package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    public ResponseEntity<String> addExpense(Expense expense) {
        expenseRepo.save(expense);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<Expense>> allExpensesById(String uid) {
        try{

            return new ResponseEntity<>(expenseRepo.findAllByUid(uid),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }
}
