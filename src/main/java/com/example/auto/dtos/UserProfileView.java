package com.example.auto.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class UserProfileView {
    private String username;
    private String firstName;
    private String lastName;
    private String imageURL;

    public UserProfileView() {};

    public UserProfileView(String username, String firstName, String lastName, String imageURL) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageURL = imageURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
