package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @GetMapping("/{uid}/all")
    public ResponseEntity<List<Expense>> allExpensesById(@PathVariable String uid){
        return expenseService.allExpensesById(uid);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteExpenseById(@PathVariable UUID id){
        return expenseService.deleteExpenseById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        return expenseService.updateExpense(expense);
    }
}
