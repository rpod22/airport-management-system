package com.ams.passengerService.flight.service;

import com.ams.passengerService.flight.model.Flight;
import com.ams.passengerService.flight.model.FlightStatus;
import com.ams.passengerService.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;
import com.ams.passengerService.gate.model.Gate;
import com.ams.passengerService.gate.repository.GateRepository;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final com.ams.passengerService.gate.repository.GateRepository gateRepository;


    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public FlightService(FlightRepository flightRepository,
                         com.ams.passengerService.gate.repository.GateRepository gateRepository) {
        this.flightRepository = flightRepository;
        this.gateRepository = gateRepository;
    }

    public Flight assignGate(Long flightId, Long gateId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        Gate gate = gateRepository.findById(gateId)
                .orElseThrow(() -> new RuntimeException("Gate not found"));

        flight.setGate(gate);
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight changeStatus(String flightNumber, FlightStatus status) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        flight.setStatus(status);
        return flightRepository.save(flight);
    }


}
