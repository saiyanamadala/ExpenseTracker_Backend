package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.service.SearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-filter")
public class SearchFilterController {

    @Autowired
    private SearchFilterService searchFilterService;

    @GetMapping("/keywordSearch")
    public ResponseEntity<List<Expense>> keywordSearch(@RequestParam String uid, @RequestParam String keyword){
        return searchFilterService.searchByKeyword(uid,keyword);
    }

    @GetMapping("/amountGreater")
    public ResponseEntity<List<Expense>> getExpenseForUidGreaterThan(@RequestParam String uid, @RequestParam float amount){
        return searchFilterService.getExpenseForUidGreaterThan(uid,amount);
    }

    @GetMapping("/amountLesser")
    public ResponseEntity<List<Expense>> getExpenseForUidLesserThan(@RequestParam String uid, @RequestParam float amount){
        return searchFilterService.getExpenseForUidLesserThan(uid,amount);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@RequestParam String uid,@RequestParam String category){
        return searchFilterService.getExpenseByCategory(uid,category);
    }

    @GetMapping("/paymentMethod")
    public ResponseEntity<List<Expense>> getExpensesByPaymentMethod(@RequestParam String uid,@RequestParam String paymentMethod){
        return searchFilterService.getExpenseBypaymentMethod(uid,paymentMethod);
    }
}
