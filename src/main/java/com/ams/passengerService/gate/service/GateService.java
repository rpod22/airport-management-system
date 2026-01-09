package com.ams.passengerService.gate.service;

import com.ams.passengerService.exception.ConflictException;
import com.ams.passengerService.exception.NotFoundException;
import com.ams.passengerService.gate.model.Gate;
import com.ams.passengerService.gate.repository.GateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {

    private final GateRepository repository;

    public GateService(GateRepository repository) {
        this.repository = repository;
    }

    public Gate createGate(Gate gate) {
        if (gate.getCode() == null || gate.getCode().isBlank()) {
            throw new ConflictException("Gate code is required");
        }
        if (repository.existsByCode(gate.getCode())) {
            throw new ConflictException("Gate with code already exists: " + gate.getCode());
        }
        return repository.save(gate);
    }

    public List<Gate> getAllGates() {
        return repository.findAll();
    }

    public Gate deactivate(String code) {
        Gate gate = repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Gate not found: " + code));
        gate.setActive(false);
        return repository.save(gate);
    }
}
