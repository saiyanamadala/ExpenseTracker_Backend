package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.Deposit;
import com.expense_tracker.Expense_Tracker_Backend.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/add")
    public ResponseEntity<String> addDeposit(@RequestBody Deposit deposit){
        return depositService.addDeposit(deposit);
    }

    @GetMapping("/{uid}/all")
    public ResponseEntity<List<Deposit>> getDeposit(@PathVariable String uid){
        return depositService.getDeposit(uid);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editDeposit(@RequestBody Deposit deposit){
        return depositService.editDeposit(deposit);
    }

    @DeleteMapping("/{depositId}/delete")
    public ResponseEntity<String> deleteDeposit(@PathVariable UUID depositId){
        return  depositService.deleteDeposit(depositId);
    }


}
