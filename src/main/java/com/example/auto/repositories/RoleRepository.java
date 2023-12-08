package com.example.auto.repositories;

import com.example.auto.models.entities.Roles;
import com.example.auto.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, String> {
    Optional<Roles> findByRoleName(RoleEnum role);
}
