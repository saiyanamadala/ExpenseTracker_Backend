package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.repository.ExpenseRepo;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.spec.EdECPrivateKeySpec;
import java.util.List;

@Service
public class SearchFilterService {

    @Autowired
    private ExpenseRepo expenseRepo;

    public ResponseEntity<List<Expense>> getExpenseForUidGreaterThan(String uid, float amount) {
        List<Expense> expenses = expenseRepo.findByUidAndAmountGreaterThanEqual(uid,amount);
        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }

    public ResponseEntity<List<Expense>> getExpenseForUidLesserThan(String uid, float amount) {
        List<Expense> expenses = expenseRepo.findByUidAndAmountLesserThanEqual(uid,amount);
        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }

    public ResponseEntity<List<Expense>> searchByKeyword(String uid, String keyword) {
        List<Expense> keywordExpenses= expenseRepo.findByKeyword(uid,keyword);

        return new ResponseEntity<>(keywordExpenses, HttpStatus.OK);
    }

    public ResponseEntity<List<Expense>> getExpenseByCategory(String uid, String category1) {
        String category = WordUtils.capitalizeFully(category1);

        List<Expense> expenses = expenseRepo.findByUidAndCategory(uid,category);

        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }

    public ResponseEntity<List<Expense>> getExpenseBypaymentMethod(String uid, String paymentMethod1) {
        String paymentMethod = WordUtils.capitalizeFully(paymentMethod1);

        List<Expense> expenses = expenseRepo.findByUidAndPaymentMethod(uid,paymentMethod);

        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }
}
