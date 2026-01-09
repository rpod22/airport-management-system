package com.ams.passengerService.service;

import com.ams.passengerService.dto.PassengerCreateRequest;
import com.ams.passengerService.dto.PassengerResponse;
import com.ams.passengerService.exception.ConflictException;
import com.ams.passengerService.exception.NotFoundException;
import com.ams.passengerService.flight.repository.FlightRepository;
import com.ams.passengerService.model.Passenger;
import com.ams.passengerService.repository.PassengerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    public PassengerService(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @Transactional
    public PassengerResponse create(PassengerCreateRequest req) {
        if (passengerRepository.existsByPassportNumber(req.getPassportNumber())) {
            throw new ConflictException("Passenger with this passport number already exists");
        }

        // jeśli podano flightNumber - sprawdź czy lot istnieje
        if (req.getFlightNumber() != null && !req.getFlightNumber().isBlank()) {
            flightRepository.findByFlightNumber(req.getFlightNumber())
                    .orElseThrow(() -> new NotFoundException("Flight not found: " + req.getFlightNumber()));
        }

        Passenger p = new Passenger(
                req.getFirstName(),
                req.getLastName(),
                req.getPassportNumber(),
                req.getFlightNumber()
        );

        return PassengerResponse.from(passengerRepository.save(p));
    }

    public List<PassengerResponse> getAll() {
        return passengerRepository.findAll().stream()
                .map(PassengerResponse::from)
                .toList();
    }

    public PassengerResponse getById(Long id) {
        Passenger p = passengerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Passenger not found: " + id));
        return PassengerResponse.from(p);
    }

    @Transactional
    public PassengerResponse checkIn(Long id) {
        Passenger p = passengerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Passenger not found: " + id));

        if (p.getFlightNumber() == null || p.getFlightNumber().isBlank()) {
            throw new ConflictException("Passenger has no flight assigned");
        }

        p.setCheckedIn(true);
        return PassengerResponse.from(passengerRepository.save(p));
    }

    @Transactional
    public PassengerResponse assignFlight(Long passengerId, String flightNumber) {
        Passenger p = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new NotFoundException("Passenger not found: " + passengerId));

        flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new NotFoundException("Flight not found: " + flightNumber));

        p.setFlightNumber(flightNumber);
        return PassengerResponse.from(passengerRepository.save(p));
    }
}
