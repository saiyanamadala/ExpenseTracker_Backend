package com.expense_tracker.Expense_Tracker_Backend.model;

public class Mail {

    private String recipient;
    private String body;
    private String subject;


    public Mail(String recipient, String body, String subject) {
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "recipient='" + recipient + '\'' +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
