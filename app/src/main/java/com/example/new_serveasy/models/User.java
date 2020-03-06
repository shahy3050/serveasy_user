package com.example.new_serveasy.models;

public class User {

    public User(String userId, String userName, String userGender, String userContact, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userGender = userGender;
        this.userContact = userContact;
        this.userAddress = userAddress;
    }

    public User() {
    }

    private String userId, userName, userGender, userContact, userAddress;

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

    public String getUserGender() {
        return userGender;
    }

    public void setUserEmail(String userGender) {
        this.userGender = userGender;
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
