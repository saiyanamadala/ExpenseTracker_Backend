package com.expense_tracker.Expense_Tracker_Backend.dto;

public class AuthUserDetails {

    private String uid;
    private String username;
    private String email;
    private String token;
    private String fullname;

    public String getUid() {
        return uid;
    }

    public AuthUserDetails() {
    }

    @Override
    public String toString() {
        return "AuthUserDetails{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    public AuthUserDetails(String uid, String username, String email, String token, String fullname) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.token = token;
        this.fullname = fullname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
