package com.ams.passengerService.gate.repository;

import com.ams.passengerService.gate.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GateRepository extends JpaRepository<Gate, Long> {
    boolean existsByCode(String code);
    Optional<Gate> findByCode(String code);
}
