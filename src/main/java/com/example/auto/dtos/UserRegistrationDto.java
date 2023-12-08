package com.example.auto.dtos;

import com.example.auto.util.UniqueUserName;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class UserRegistrationDto {
    @UniqueUserName
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String imageURL;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime modified;

    @NotEmpty
    @Length(min = 5, message = "UserName must be more than 5 characters!")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty
    @Length(min = 10, message = "Password must be more than 10 characters!")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    @Length(min = 10, message = "Confirm password must be more than 10 characters!")
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotEmpty
    @Length(min = 2, message = "First name must be more than 2 characters!")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty
    @Length(min = 2, message = "Last name must be more than 2 characters!")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotEmpty(message = "URL of image cannot be null or empty!")
    @Length(min = 10, max = 300, message = "URL of image must be more than 10 characters!")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }


    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
