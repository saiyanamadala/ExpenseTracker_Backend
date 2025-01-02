package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import com.expense_tracker.Expense_Tracker_Backend.repository.ExpenseRepo;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchFilterService {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private PaymentMethodsService paymentMethodsService;

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

    public ResponseEntity<List<Expense>> getExpensesBetweenDates(String uid, Date startDate, Date endDate) {
        List<Expense> expenses = expenseRepo.findByUidAndDateBetween(uid,startDate,endDate);

        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }

    public ResponseEntity<Map<String, HashMap<String, Float>>> getSpendAnalysis(String uid, int noMonths) {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, -noMonths);
        Date startDate = calendar.getTime();

        List<Expense> expenses = expenseRepo.findByUidAndDateBetween(uid,startDate,currentDate);

        //List<String> paymentMethods = paymentMethodsService.allPaymentMethods(uid).getBody();

        HashMap<String,Float> paymentMethodsAnalysis = new HashMap<>();
        HashMap<String,Float> categoryMethodsAnalysis = new HashMap<>();

        for(Expense expense: expenses){
            if(paymentMethodsAnalysis.containsKey(expense.getPaymentMethod())){
                paymentMethodsAnalysis.put(expense.getPaymentMethod(),paymentMethodsAnalysis.get(expense.getPaymentMethod())+expense.getAmount());
            }
            else{
                paymentMethodsAnalysis.put(expense.getPaymentMethod(),expense.getAmount());
            }

            if(categoryMethodsAnalysis.containsKey(expense.getCategory())){
                categoryMethodsAnalysis.put(expense.getCategory(),categoryMethodsAnalysis.get(expense.getCategory())+expense.getAmount());
            }
            else{
                categoryMethodsAnalysis.put(expense.getCategory(),expense.getAmount());
            }
        }

        Map<String, HashMap<String,Float>> analysis = new HashMap<>();

        analysis.put("paymentMethod",paymentMethodsAnalysis);
        analysis.put("category",categoryMethodsAnalysis);

        return new ResponseEntity<>(analysis, HttpStatus.OK);

    }
}
