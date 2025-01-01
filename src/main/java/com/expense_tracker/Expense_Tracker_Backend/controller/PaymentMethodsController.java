package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.PaymentMethods;
import com.expense_tracker.Expense_Tracker_Backend.service.PaymentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentMethods")
public class PaymentMethodsController {

    @Autowired
    private PaymentMethodsService paymentMethodsService;

    @PostMapping("/add")
    public ResponseEntity<String> addPaymentMethod(@RequestBody PaymentMethods paymentMethod){
        return paymentMethodsService.addPaymentMethod(paymentMethod);
    }

    @GetMapping("/{uid}/all")
    public ResponseEntity<List<String>> allPaymentMethods(@PathVariable String uid){
        return paymentMethodsService.allPaymentMethods(uid);
    }
}
