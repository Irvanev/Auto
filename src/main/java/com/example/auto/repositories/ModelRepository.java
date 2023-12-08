package com.example.auto.repositories;

import com.example.auto.models.entities.Models;
import com.example.auto.models.enums.CategoryEnum;
import com.example.auto.models.enums.EngineEnum;
import com.example.auto.models.enums.TransmissionEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Models, String> {
    Optional<Models> findById(String id);
    List<Models> findByBrandsName(String brandName);
    List<Models> findByName(String name);
    List<Models> findByYear(int year);
    List<Models> findByMileage(int mileage);
    List<Models> findByPrice(BigDecimal price);
    List<Models> findByCategory(CategoryEnum category);
    List<Models> findByEngine(EngineEnum engine);
    List<Models> findByTransmission(TransmissionEnum transmission);
    void deleteById(String id);
}
