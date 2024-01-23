package com.example.auto.models.entities;

import com.example.auto.models.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
public class Users extends BaseEntity {
    private List<Offers> offers;
    private Roles role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String imageURL;

    public Users() {
    }

    public Users(String username, String password, String firstName, String lastName, String imageURL) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageURL = imageURL;
    }

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    public List<Offers> getOffers() {
        return offers;
    }
    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    @Column(unique = true, name="username", length = 255, nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String login) {
        this.username = username;
    }

    @Column(name="password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="firstName", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="imageURL", nullable = false)
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
