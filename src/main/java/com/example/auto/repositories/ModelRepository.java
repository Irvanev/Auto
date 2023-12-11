package com.example.auto.repositories;

import com.example.auto.models.entities.Models;
import com.example.auto.models.enums.CategoryEnum;
import com.example.auto.models.enums.EngineEnum;
import com.example.auto.models.enums.TransmissionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Models, String> {
    Optional<Models> findById(String id);
    List<Models> findByCategory(CategoryEnum category);
    List<Models> findByBrandsName(String brandName);
    @Modifying
    @Transactional
    void deleteById(String id);
}
