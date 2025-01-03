package com.expense_tracker.Expense_Tracker_Backend.repository;

import com.expense_tracker.Expense_Tracker_Backend.model.Deposit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DepositRepo extends MongoRepository<Deposit, UUID> {
    List<Deposit> findAllByUid(String uid);

    Optional<Deposit> findByDepositId(UUID depositId);

    void deleteByDepositId(UUID depositId);
}
