package com.expense_tracker.Expense_Tracker_Backend.dto;

public class AuthUserDetails {

    private String uid;
    private String username;
    private String email;
    private String token;

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

    @Override
    public String toString() {
        return "AuthUserDetails{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public AuthUserDetails(String uid, String username, String email, String token) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.token = token;
    }

    public AuthUserDetails() {
    }
}
