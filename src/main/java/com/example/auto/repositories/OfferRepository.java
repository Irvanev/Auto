package com.example.auto.repositories;

import com.example.auto.models.entities.Offers;
import com.example.auto.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offers, String> { }
