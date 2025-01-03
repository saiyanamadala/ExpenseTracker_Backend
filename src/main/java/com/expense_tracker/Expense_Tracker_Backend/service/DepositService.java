package com.expense_tracker.Expense_Tracker_Backend.service;

import com.expense_tracker.Expense_Tracker_Backend.model.Deposit;
import com.expense_tracker.Expense_Tracker_Backend.repository.DepositRepo;
import com.sun.net.httpserver.HttpsServer;
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
public class DepositService {

    @Autowired
    private DepositRepo depositRepo;

    public ResponseEntity<String> addDeposit(Deposit deposit) {
        deposit.setTitle(WordUtils.capitalizeFully(deposit.getTitle()));
        deposit.setDepositSource(WordUtils.capitalizeFully(deposit.getDepositSource()));
        depositRepo.save(deposit);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<Deposit>> getDeposit(String uid) {
        try{
            return new ResponseEntity<>(depositRepo.findAllByUid(uid),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> editDeposit(Deposit deposit) {
        Optional<Deposit> storedDeposit = depositRepo.findByDepositId(deposit.getDepositId());

        if(storedDeposit.isPresent()){
            Deposit depositStored = storedDeposit.get();

            depositStored.setAmount(deposit.getAmount());
            depositStored.setDate(deposit.getDate());
            depositStored.setDepositSource(WordUtils.capitalizeFully(deposit.getDepositSource()));
            depositStored.setTitle(WordUtils.capitalizeFully(deposit.getTitle()));

            depositRepo.save(depositStored);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Invalid depositId", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<String> deleteDeposit(UUID depositId) {

        Optional<Deposit> storedDeposit = depositRepo.findByDepositId(depositId);

        if(storedDeposit.isPresent()){
            Deposit depositStored = storedDeposit.get();
            depositRepo.deleteByDepositId(depositId);

            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Invalid depositId",HttpStatus.BAD_REQUEST);
        }
    }
}
