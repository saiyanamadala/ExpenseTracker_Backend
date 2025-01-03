package com.expense_tracker.Expense_Tracker_Backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class Deposit {

    @Id
    private UUID depositId;
    private String uid;
    private float amount;
    private Date date;
    private String depositSource;
    private String title;

    public UUID getDepositId() {
        return depositId;
    }

    public void setDepositId(UUID depositId) {
        this.depositId = depositId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepositSource() {
        return depositSource;
    }

    public void setDepositSource(String depositSource) {
        this.depositSource = depositSource;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "depositId=" + depositId +
                ", uid='" + uid + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", depositSource='" + depositSource + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Deposit(UUID depositId, String uid, float amount, Date date, String depositSource, String title) {
        this.depositId = depositId;
        this.uid = uid;
        this.amount = amount;
        this.date = date;
        this.depositSource = depositSource;
        this.title = title;
    }
}
