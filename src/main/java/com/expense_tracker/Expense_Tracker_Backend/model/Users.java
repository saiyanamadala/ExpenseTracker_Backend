package com.expense_tracker.Expense_Tracker_Backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Users {

    @Id
    private String uid;
    private String username;
    private String password;
    private String email;
    private String fullname;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Users(String uid, String username, String password, String email, String fullname) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    public Users() {
    }
}
