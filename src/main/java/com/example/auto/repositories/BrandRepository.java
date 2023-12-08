package com.example.auto.repositories;

import com.example.auto.models.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brands, String> {
    Optional<Brands> findByName(String name);
    void deleteByName(String name);
}
