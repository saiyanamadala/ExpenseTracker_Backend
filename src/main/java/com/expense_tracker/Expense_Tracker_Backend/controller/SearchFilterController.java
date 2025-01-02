package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.service.SearchFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/dates-filter")
    public ResponseEntity<List<Expense>> getExpensesBetweenDates(@RequestParam String uid, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        return searchFilterService.getExpensesBetweenDates(uid,startDate,endDate);
    }

    @GetMapping("/analyze")
    public ResponseEntity<Map<String, HashMap<String, Float>>> getSpendAnalysis(@RequestParam String uid, @RequestParam int noMonths){
        return searchFilterService.getSpendAnalysis(uid,noMonths);
    }
}
