package com.example.auto.dtos;

import com.example.auto.models.enums.OfferEnum;

import java.time.LocalDateTime;

public class AllOffersDto {
    private String modelName;
    private String userName;
    private OfferEnum status;
    private LocalDateTime created;
    private LocalDateTime modified;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OfferEnum getStatus() {
        return status;
    }

    public void setStatus(OfferEnum status) {
        this.status = status;
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
