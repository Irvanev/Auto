package com.example.auto.repositories;

import com.example.auto.models.entities.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offers,String> {
}
