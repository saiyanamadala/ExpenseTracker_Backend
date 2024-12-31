package com.expense_tracker.Expense_Tracker_Backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import java.util.UUID;

@Document
public class Expense {

    @Id
    private UUID id;
    private String uid;
    private String title;
    private String paymentMethod;
    private String category;
    private Date date;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                '}';
    }

    public Expense(UUID id, String uid, String title, String paymentMethod, String category, Date date) {
        this.id = id;
        this.uid = uid;
        this.title = title;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.date = date;
    }

    public Expense() {
    }
}
