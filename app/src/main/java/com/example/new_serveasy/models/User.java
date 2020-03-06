package com.example.new_serveasy.models;

public class User {

    public User(String userId, String userName, String userEmail, String userContact, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
        this.userAddress = userAddress;
    }

    private String userId, userName, userEmail, userContact, userAddress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
