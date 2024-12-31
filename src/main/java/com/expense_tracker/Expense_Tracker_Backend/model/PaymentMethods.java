package com.expense_tracker.Expense_Tracker_Backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PaymentMethods {

    private String uid;
    private String paymentMethod;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethods(String uid, String paymentMethod) {
        this.uid = uid;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "uid='" + uid + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public PaymentMethods() {
    }
}
