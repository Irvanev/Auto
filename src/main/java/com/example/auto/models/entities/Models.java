package com.example.auto.models.entities;

import com.example.auto.models.enums.CategoryEnum;
import com.example.auto.models.enums.EngineEnum;
import com.example.auto.models.enums.TransmissionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Models extends BaseEntity {
    private List<Offers> offers;
    private Brands brands;
    private String name;
    private CategoryEnum category;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private int startYear;
    private int endYear;
    private int mileage;
    private String description;
    private String imageURL;
    private BigDecimal price;
    private int year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "models", cascade = CascadeType.REMOVE)
    public List<Offers> getOffers() {
        return offers;
    }
    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    @ManyToOne
    @JoinColumn(name = "brand_id")
    public Brands getBrands() {
        return brands;
    }
    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    @Column(name="name", length = 100, nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="category", length = 11, nullable = false)
    public CategoryEnum getCategory() {
        return category;
    }
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="engine", length = 11, nullable = false)
    public EngineEnum getEngine() {
        return engine;
    }
    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="transmission", length = 20, nullable = false)
    public TransmissionEnum getTransmission() {
        return transmission;
    }
    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    @Column(name="startYear", length = 4, nullable = false)
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(name="endYear", length = 4, nullable = false)
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @Column(name="miliage", length = 10, nullable = false)
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name="description", length = 500, nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="imageURL", length = 260, nullable = false)
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name="price", length = 20, nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name="year", length = 11, nullable = false)
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
