package com.ams.passengerService.gate.controller;

import com.ams.passengerService.gate.model.Gate;
import com.ams.passengerService.gate.service.GateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gates")
public class GateController {

    private final GateService service;

    public GateController(GateService service) {
        this.service = service;
    }

    @PostMapping
    public Gate create(@RequestBody Gate gate) {
        return service.createGate(gate);
    }

    @GetMapping
    public List<Gate> all() {
        return service.getAllGates();
    }

    @PatchMapping("/{code}/deactivate")
    public Gate deactivate(@PathVariable String code) {
        return service.deactivate(code);
    }
}
