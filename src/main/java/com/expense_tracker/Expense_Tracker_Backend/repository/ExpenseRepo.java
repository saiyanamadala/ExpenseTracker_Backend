package com.expense_tracker.Expense_Tracker_Backend.repository;

import com.expense_tracker.Expense_Tracker_Backend.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepo extends MongoRepository<Expense, UUID> {
    List<Expense> findAllByUid(String uid);

    @Query("{ 'uid': ?0, $or: [ { 'title': { $regex: ?1, $options: 'i' } }, { 'category': { $regex: ?1, $options: 'i' } }, { 'paymentMethod': { $regex: ?1, $options: 'i' } } ] }")
    List<Expense> findByKeyword(String uid, String keyword);

    @Query("{'uid': ?0, 'amount': { $gte: ?1 }}")
    List<Expense> findByUidAndAmountGreaterThanEqual(String uid, float amount);

    @Query("{'uid': ?0, 'amount': { $lte: ?1 }}")
    List<Expense> findByUidAndAmountLesserThanEqual(String uid, float amount);
    
    List<Expense> findByUidAndCategory(String uid, String category);
    
    List<Expense> findByUidAndPaymentMethod(String uid, String paymentMethod);

    @Query("{ 'uid': ?0, 'date': { $gte: ?1, $lte: ?2 } }")
    List<Expense> findByUidAndDateBetween(String uid, Date startDate, Date endDate);
}
