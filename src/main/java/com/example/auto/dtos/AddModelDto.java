package com.example.auto.dtos;

import com.example.auto.models.enums.CategoryEnum;
import com.example.auto.models.enums.EngineEnum;
import com.example.auto.models.enums.TransmissionEnum;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddModelDto {
    private String name;
    private String brandName;
    private TransmissionEnum transmission;
    private EngineEnum engine;
    private CategoryEnum category;
    private int startYear;
    private int endYear;
    private int year;
    private int mileage;
    private BigDecimal price;
    private String description;
    private String imageURL;
    private LocalDateTime created;
    private LocalDateTime modified;

    @NotEmpty(message = "Name of model cannot be null or empty!")
    @Size(min = 2, message = "Name of model should be at least 2 characters long!")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }
    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }


    public EngineEnum getEngine() {
        return engine;
    }
    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }


    public CategoryEnum getCategory() {
        return category;
    }
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Min(value = 1800, message = "Start year must be a positive number!")
    @Max(value = 2024, message = "Start year must not be more")
    @NotNull(message = "Start year must not be null or empty!")
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Min(value = 1800, message = "End year must be a positive number!")
    @Max(value = 2024, message = "End year must not be more")
    @NotNull(message = "End year must not be null or empty!")
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @Min(value = 1800, message = "Year must be a positive number!")
    @Max(value = 2024, message = "Year must not be more")
    @NotNull(message = "Year must not be null or empty!")
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Min(value = 1, message = "Mileage must be a positive number!")
    @NotNull(message = "Mileage must not be null or empty!")
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Min(value = 1, message = "Price must be a positive number!")
    @NotNull(message = "Price must not be null or empty!")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotEmpty(message = "Description cannot be null or empty!")
    @Size(min = 2, max = 200, message = "Description should be at least 2 characters long!")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @NotEmpty(message = "Description cannot be null or empty!")
    @Size(min = 2, max=300, message = "Description should be at least 2 characters long!")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
