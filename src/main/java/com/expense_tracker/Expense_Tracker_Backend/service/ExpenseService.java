package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.repository.ExpenseRepo;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    public ResponseEntity<String> addExpense(Expense expense) {
        expense.setTitle(WordUtils.capitalizeFully(expense.getTitle()));
        expense.setCategory(WordUtils.capitalizeFully(expense.getCategory()));
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

    public ResponseEntity<String> deleteExpenseById(UUID id) {
        Optional<Expense> expense = expenseRepo.findById(id);

        if(expense.isPresent()){
            expenseRepo.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No record found",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Expense> updateExpense(Expense expense) {
        Optional<Expense> expenseStored = expenseRepo.findById(expense.getId());

        if(expenseStored.isPresent()){
            Expense storedExpense = expenseStored.get();
            storedExpense.setAmount(expense.getAmount());
            storedExpense.setDate(expense.getDate());
            storedExpense.setCategory(expense.getCategory());
            storedExpense.setPaymentMethod(expense.getPaymentMethod());
            storedExpense.setTitle(expense.getTitle());

            Expense updatedExpense = expenseRepo.save(storedExpense);
            return new ResponseEntity<>(updatedExpense,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
