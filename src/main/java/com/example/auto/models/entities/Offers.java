package com.example.auto.models.entities;

import com.example.auto.models.enums.OfferEnum;
import jakarta.persistence.*;

@Entity
public class Offers extends BaseEntity {
    private Users users;
    private Models models;
    private OfferEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne
    @JoinColumn(name = "model_id")
    public Models getModels() {
        return models;
    }
    public void setModels(Models models) {
        this.models = models;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="status", length = 11, nullable = false)
    public OfferEnum getStatus() {
        return status;
    }
    public void setStatus(OfferEnum status) {
        this.status = status;
    }
}
