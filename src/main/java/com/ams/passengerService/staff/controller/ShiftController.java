package com.ams.passengerService.staff.controller;

import com.ams.passengerService.staff.dto.ShiftCreateRequest;
import com.ams.passengerService.staff.model.Shift;
import com.ams.passengerService.staff.service.ShiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    private final ShiftService service;

    public ShiftController(ShiftService service) {
        this.service = service;
    }

    @PostMapping
    public Shift create(@RequestBody ShiftCreateRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<Shift> all() {
        return service.all();
    }

    @GetMapping("/staff/{staffId}")
    public List<Shift> byStaff(@PathVariable Long staffId) {
        return service.byStaff(staffId);
    }
}

