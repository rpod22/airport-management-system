package com.ams.passengerService.controller;

import com.ams.passengerService.dto.PassengerCreateRequest;
import com.ams.passengerService.dto.PassengerResponse;
import com.ams.passengerService.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @PostMapping
    public PassengerResponse create(@RequestBody @Valid PassengerCreateRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<PassengerResponse> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PassengerResponse byId(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}/check-in")
    public PassengerResponse checkIn(@PathVariable Long id) {
        return service.checkIn(id);
    }

    @PatchMapping("/{id}/flight/{flightNumber}")
    public PassengerResponse assignFlight(@PathVariable Long id, @PathVariable String flightNumber) {
        return service.assignFlight(id, flightNumber);
    }
}
