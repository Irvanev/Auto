package com.example.auto.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brands extends BaseEntity{
    private List<Models> models;
    private String name;
    private String country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brands", cascade = CascadeType.REMOVE)
    public List<Models> getModels() {
        return models;
    }
    public void setModels(List<Models> models) {
        this.models = models;
    }

    @Column(name="name", length = 255, nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="country", length = 255, nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name;
    }
}
