package com.ams.passengerService.flight.controller;

import com.ams.passengerService.flight.model.Flight;
import com.ams.passengerService.flight.model.FlightStatus;
import com.ams.passengerService.flight.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping
    public Flight create(@RequestBody Flight flight) {
        return service.createFlight(flight);
    }

    @GetMapping
    public List<Flight> all() {
        return service.getAllFlights();
    }

    @PatchMapping("/{flightNumber}/status/{status}")
    public Flight changeStatus(
            @PathVariable String flightNumber,
            @PathVariable FlightStatus status
    ) {
        return service.changeStatus(flightNumber, status);
    }

    @PostMapping("/{flightId}/gate/{gateId}")
    public Flight assignGate(
            @PathVariable Long flightId,
            @PathVariable Long gateId) {

        return service.assignGate(flightId, gateId);
    }



}
