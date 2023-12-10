package com.example.auto.repositories;

import com.example.auto.models.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brands, String> {
    Optional<Brands> findByName(String name);
    @Modifying
    @Transactional
    void deleteByName(String name);
}
