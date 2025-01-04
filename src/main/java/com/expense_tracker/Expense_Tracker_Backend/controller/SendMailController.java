package com.expense_tracker.Expense_Tracker_Backend.controller;

import com.expense_tracker.Expense_Tracker_Backend.model.Mail;
import com.expense_tracker.Expense_Tracker_Backend.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping("sendMail")
    public ResponseEntity<String> sendMail(@RequestBody Mail mail){
        return sendEmailService.sendEmail(mail.getRecipient(),mail.getBody(),mail.getSubject());
    }
}
