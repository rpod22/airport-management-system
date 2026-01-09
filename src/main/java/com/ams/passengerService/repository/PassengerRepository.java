package com.ams.passengerService.repository;

import com.ams.passengerService.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findByPassportNumber(String passportNumber);
    boolean existsByPassportNumber(String passportNumber);
}
