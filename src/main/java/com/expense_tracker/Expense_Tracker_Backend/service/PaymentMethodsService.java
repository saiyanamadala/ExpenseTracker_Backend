package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.PaymentMethods;
import com.expense_tracker.Expense_Tracker_Backend.repository.PaymentMethodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodsService {

    @Autowired
    private PaymentMethodsRepo paymentMethodsRepo;

    public ResponseEntity<String> addPaymentMethod(PaymentMethods paymentMethod) {
        paymentMethodsRepo.save(paymentMethod);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<PaymentMethods>> allPaymentMethods(String uid) {
        Optional<List<PaymentMethods>> paymentsStored = paymentMethodsRepo.findAllByUid(uid);

        if(paymentsStored.isPresent()){
            List<PaymentMethods> storedPayments = paymentsStored.get();
            return new ResponseEntity<>(storedPayments,HttpStatus.OK);

        }else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }

//        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }
}
