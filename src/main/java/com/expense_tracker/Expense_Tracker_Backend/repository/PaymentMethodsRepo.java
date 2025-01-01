package com.expense_tracker.Expense_Tracker_Backend.repository;

import com.expense_tracker.Expense_Tracker_Backend.model.PaymentMethods;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodsRepo extends MongoRepository<PaymentMethods,String> {
    Optional<List<PaymentMethods>> findAllByUid(String uid);


    boolean existsByUidAndPaymentMethod(String uid, String paymentMethod);
}
