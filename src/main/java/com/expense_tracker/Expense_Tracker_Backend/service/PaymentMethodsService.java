package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.PaymentMethods;
import com.expense_tracker.Expense_Tracker_Backend.repository.PaymentMethodsRepo;
import org.apache.commons.text.WordUtils;
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
        boolean exists = paymentMethodsRepo.existsByUidAndPaymentMethod(paymentMethod.getUid(), paymentMethod.getPaymentMethod());
        if(exists){
            return new ResponseEntity<>("Payment method already exists for user",HttpStatus.CONFLICT);
        }
        paymentMethod.setPaymentMethod(WordUtils.capitalizeFully(paymentMethod.getPaymentMethod()));
        paymentMethodsRepo.save(paymentMethod);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<String>> allPaymentMethods(String uid) {
        Optional<List<PaymentMethods>> paymentsStored = paymentMethodsRepo.findAllByUid(uid);

        if(paymentsStored.isPresent()){
            List<PaymentMethods> storedPayments = paymentsStored.get();
            List<String> payments = new ArrayList<>();

            for(PaymentMethods p: storedPayments){
                payments.add(p.getPaymentMethod());
            }

            return new ResponseEntity<>(payments,HttpStatus.OK);

        }else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
    }
}
