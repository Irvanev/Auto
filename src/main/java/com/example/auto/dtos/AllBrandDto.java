package com.example.auto.dtos;

import com.example.auto.util.UniqueBrandName;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class AllBrandDto {
    @UniqueBrandName
    private String name;
    private String country;
    private LocalDateTime created;
    private LocalDateTime modified;

    @NotEmpty
    @Length(min = 2, message = "Name of brand must be more than 2 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @Length(min = 2, message = "Country of brand must be more than 2 characters!")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
